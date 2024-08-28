package com.siseven.adm.suagendabarber.services.impl;

import com.siseven.adm.suagendabarber.dto.ProfissionalDTO;
import com.siseven.adm.suagendabarber.entities.ProfissionalEntity;
import com.siseven.adm.suagendabarber.repositories.ProfissionalRepository;
import com.siseven.adm.suagendabarber.services.exceptions.EntityNotFoundException;
import com.siseven.adm.suagendabarber.services.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository repository;

    public List<ProfissionalDTO> listarProfissionais() {
        List<ProfissionalEntity> profissionais = repository.findAll();
        if (profissionais.isEmpty()) {
            throw new EntityNotFoundException("Não foi possível encontrar registros.");
        }
        return profissionais.stream().map(ProfissionalDTO::new).toList();
    }

    public ProfissionalDTO buscarProfissional(Long id) {
        ProfissionalEntity profissional = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado com o id: " + id));
        return new ProfissionalDTO(profissional);
    }

    public void incluirProfissional(ProfissionalDTO profissional) {
        if (profissional != null && profissional.getId() == null) {
            repository.save(new ProfissionalEntity(profissional));
            return;
        }
        if (profissional != null && profissional.getId() != null) {
            boolean existe = repository.findById(profissional.getId()).isPresent();
            if (existe) {
                repository.save(new ProfissionalEntity(profissional));
                return;
            }
            throw new EntityNotFoundException("Não foi possível encontrar o profissional:" + profissional.getNome());
        }
        throw new InvalidArgumentException("erro ao incluir ou atualizar profissional");
    }

    public void excluirProfissional(Long id) {
        boolean profissional =  repository.findById(id).isPresent();
        if (profissional) {
            repository.deleteById(id);
            return;
        }
        throw new EntityNotFoundException("Não foi possível excluir o registro, o mesmo não existe.");
    }


}
