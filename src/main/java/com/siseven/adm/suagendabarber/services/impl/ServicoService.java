package com.siseven.adm.suagendabarber.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.siseven.adm.suagendabarber.services.exceptions.EntityNotFoundException;
import com.siseven.adm.suagendabarber.services.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siseven.adm.suagendabarber.dto.ServicoDTO;
import com.siseven.adm.suagendabarber.entities.ServicoEntity;
import com.siseven.adm.suagendabarber.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository repository;

	public List<ServicoDTO> obterServicosCadastrados() {
		List<ServicoEntity> servicos = repository.findAll();
		if (servicos.isEmpty()) {
			throw new EntityNotFoundException("Não existem serviços cadastrados");
		}
		return servicos.stream().map(ServicoDTO::new).toList();
	}

	public void incluirServico(ServicoDTO servico) {
		if (servico.getNome() == null || servico.getNome().isBlank()) {
			throw new InvalidArgumentException("Nome inválido ou vazio");
		}
		if (servico.getValor() == null || servico.getValor().toString().isBlank()) {
			throw new InvalidArgumentException("Valor inválido ou vazio");
		}
		if (servico.getQtSlots() == null || servico.getQtSlots().toString().isBlank()) {
			throw new InvalidArgumentException("Slot inválido ou vazio");
		}
		repository.save(new ServicoEntity(servico));
	}

	public void atualizarServico(ServicoDTO servico) {
		if (servico != null && servico.getId() != null) {
			Optional<ServicoEntity> servicoExistente = repository.findById(servico.getId());
			if (servicoExistente.isPresent()) {
				ServicoEntity servicoEntity = servicoExistente.get();
				repository.save(servicoEntity);
			} else {
				throw new InvalidArgumentException("Serviço não encontrado com o ID: " + servico.getId());
			}
		} else {
			throw new InvalidArgumentException("Argumento inválido ou vazio");
		}
	}

	public void deletarServico(Long id) {
		boolean servico = repository.findById(id).isPresent();
		if (servico) {
			repository.deleteById(id);
			return;
		}
		throw new EntityNotFoundException("Não foi possível excluir o registro, o mesmo não existe.");
	}

}
