package com.siseven.adm.suagendabarber.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.siseven.adm.suagendabarber.dto.ProfissionalDTO;
import com.siseven.adm.suagendabarber.dto.ServicoDTO;
import com.siseven.adm.suagendabarber.entities.ClienteEntity;
import com.siseven.adm.suagendabarber.entities.ServicoEntity;
import com.siseven.adm.suagendabarber.repositories.ClienteRepository;
import com.siseven.adm.suagendabarber.repositories.ProfissionalRepository;
import com.siseven.adm.suagendabarber.repositories.ServicoRepository;
import com.siseven.adm.suagendabarber.services.exceptions.EntityNotFoundException;
import com.siseven.adm.suagendabarber.services.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siseven.adm.suagendabarber.dto.AgendamentoDTO;
import com.siseven.adm.suagendabarber.entities.AgendamentoEntity;
import com.siseven.adm.suagendabarber.entities.ProfissionalEntity;
import com.siseven.adm.suagendabarber.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository repository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ServicoRepository servicoRepository;
	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public List<AgendamentoDTO> buscarTodos() {
		List<AgendamentoEntity> agendamentos = repository.findAll();
		if (agendamentos.isEmpty()) {
			throw new EntityNotFoundException("Não existem agendamentos disponíveis");
		}
		return agendamentos.stream().map(AgendamentoDTO::new).toList();
	}

	public List<AgendamentoDTO> buscarTodosPorData(AgendamentoDTO data) {
		List<AgendamentoEntity> agendamentos = repository.findByData(data.getData());
		return agendamentos.stream().map(AgendamentoDTO::new).toList();
	}
	
	public List<AgendamentoDTO> buscarPorProfissional(AgendamentoDTO profissional) {
		ProfissionalEntity profissionalEntity = profissionalRepository.findById(profissional.getProfissional().getId())
				.orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado"));
		List<AgendamentoEntity> agendamentos = repository.findByProfissional(profissionalEntity);
		return agendamentos.stream().map(AgendamentoDTO::new).toList();
	}

	public List<AgendamentoDTO> buscarPorProfissionalEData(AgendamentoDTO agendaPessoal) {
		ProfissionalEntity profissionalEntity = profissionalRepository.findById(agendaPessoal.getProfissional().getId())
				.orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado"));
		List<AgendamentoEntity> agendamentos = repository.findByProfissionalAndData(profissionalEntity, agendaPessoal.getData());
		return agendamentos.stream().map(AgendamentoDTO::new).toList();
	}

	public void atualizarAgendamento(AgendamentoDTO agendamento) {
		if (agendamento != null && agendamento.getId() != null) {
			Optional<AgendamentoEntity> agendamentoExistente = repository.findById(agendamento.getId());

			ClienteEntity cliente = clienteRepository.findById(agendamento.getCliente().getId())
					.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
			ServicoEntity servico = servicoRepository.findById(agendamento.getServico().getId())
					.orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado"));
			ProfissionalEntity profissional = profissionalRepository.findById(agendamento.getProfissional().getId())
					.orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado"));

			if (agendamentoExistente.isPresent()) {
				AgendamentoEntity agendamentoEntity = agendamentoExistente.get();
				agendamentoEntity.setCliente(cliente);
				agendamentoEntity.setServico(servico);
				agendamentoEntity.setProfissional(profissional);
				repository.save(agendamentoEntity);
			} else {
				throw new InvalidArgumentException("Agendamento não encontrado com o ID: " + agendamento.getId());
			}
		} else {
			throw new InvalidArgumentException("Argumento inválido ou vazio");
		}
	}

	public void incluirAgendamento(AgendamentoDTO agendamento) {
		AgendamentoEntity agendamentoEntity = new AgendamentoEntity(agendamento);

		ClienteEntity cliente = clienteRepository.findById(agendamento.getCliente().getId())
				.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
		ServicoEntity servico = servicoRepository.findById(agendamento.getServico().getId())
				.orElseThrow(() -> new EntityNotFoundException("Serviço não encontrado"));
		ProfissionalEntity profissional = profissionalRepository.findById(agendamento.getProfissional().getId())
				.orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado"));

		agendamentoEntity.setCliente(cliente);
		agendamentoEntity.setServico(servico);
		agendamentoEntity.setProfissional(profissional);
		if (agendamento.getId() == null) {
			repository.save(agendamentoEntity);
			return;
		}
		if (agendamento.getId() != null) {
			boolean existe = repository.findById(agendamento.getId()).isPresent();
			if (existe) {
				repository.save(new AgendamentoEntity(agendamento));
				return;
			}
			throw new EntityNotFoundException("Erro ao atualizar agendamento");
		}
		throw new InvalidArgumentException("Argumento inválido, tente novamente");
	}


	public void excluirAgendamento(Long id) {
		if (id != null) {
			boolean existe = repository.findById(id).isPresent();
			if (existe) {
				repository.deleteById(id);
				return;
			}
			throw new InvalidArgumentException("Erro ao exluir agendamento");
		}
		throw new InvalidArgumentException("Erro ao buscar agendamento com o id: " + id);
	}

}
