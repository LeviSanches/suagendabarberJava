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
		if (servico != null && servico.getId() == null) {
			repository.save(new ServicoEntity(servico));
			return;
		}
		if (servico != null && servico.getId() != null) {
			boolean existe = repository.findById(servico.getId()).isPresent();
			if (existe) {
				repository.save(new ServicoEntity(servico));
				return;
			}
			throw new InvalidArgumentException("Erro ao atualizar serviço");
		}
		throw new InvalidArgumentException("Erro ao incluir serviço");
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
