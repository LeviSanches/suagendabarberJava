package com.siseven.adm.suagendabarber.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.siseven.adm.suagendabarber.dto.ProfissionalDTO;
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

	public List<AgendamentoDTO> buscarTodosPorData(LocalDate data) {
		List<AgendamentoEntity> agendamentos = repository.findByData(data);
		return agendamentos.stream().map(AgendamentoDTO::new).toList();
	}
	
	public List<AgendamentoDTO> buscarTodosPorDataEProfissional(LocalDate data, ProfissionalDTO profissional) {
		ProfissionalEntity profissionalEntity = new ProfissionalEntity(profissional);
		List<AgendamentoEntity> agendamentos = repository.findByDataAndProfissional(data, profissionalEntity);
		return agendamentos.stream().map(AgendamentoDTO::new).toList();
	}

	public void atualizarAgendamento(AgendamentoDTO agendamento) {
		if (agendamento != null && agendamento.getId() != null) {
			Optional<AgendamentoEntity> agendamentoExistente = repository.findById(agendamento.getId());
			if (agendamentoExistente.isPresent()) {
				AgendamentoEntity agendamentoEntity = agendamentoExistente.get();
				repository.save(agendamentoEntity);
			} else {
				throw new InvalidArgumentException("Agendamento não encontrado com o ID: " + agendamento.getId());
			}
		} else {
			throw new InvalidArgumentException("Argumento inválido ou vazio");
		}
	}

	public void incluirAgendamento(AgendamentoDTO agendamento) {
		if (agendamento == null) {
			throw new InvalidArgumentException("Argumento inválido, tente novamente");
		}
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

		repository.save(agendamentoEntity);
	}


	public void excluirAgendamento(Long id) {
		boolean existe = repository.findById(id).isPresent();
		if (existe) {
			AgendamentoEntity agendamento = repository.findById(id).get();
			repository.delete(agendamento);
		}
		throw new EntityNotFoundException("Erro ao excluir agendamento com o id: " + id);
	}
	
	

}
