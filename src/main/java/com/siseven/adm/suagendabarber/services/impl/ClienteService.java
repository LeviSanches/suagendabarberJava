package com.siseven.adm.suagendabarber.services.impl;

import com.siseven.adm.suagendabarber.dto.ClienteDTO;
import com.siseven.adm.suagendabarber.entities.AgendamentoEntity;
import com.siseven.adm.suagendabarber.entities.ClienteEntity;
import com.siseven.adm.suagendabarber.repositories.ClienteRepository;
import com.siseven.adm.suagendabarber.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public List<ClienteDTO> listarClientes() {
        List<ClienteEntity> clientes = repository.findAll();
        if (clientes.isEmpty()) {
            throw new EntityNotFoundException("Não existem clientes disponíveis");
        }
        return clientes.stream().map(ClienteDTO::new).toList();
    }

    public ClienteDTO buscarCliente(Long id) {
        boolean existe = repository.findById(id).isPresent();
        if (existe) {
            ClienteEntity cliente = repository.findById(id).get();
            return new ClienteDTO(cliente);
        }
        throw new EntityNotFoundException("Erro ao buscar cliente com id: " + id);
    }

    public void incluirCliente(ClienteDTO cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Erro ao incluir cliente.");
        }
        ClienteEntity clienteEntity = new ClienteEntity(cliente);
        repository.save(clienteEntity);
    }

    public void atualizarCliente(ClienteDTO cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Erro ao atualizar cliente.");
        }
        boolean existe = repository.findById(cliente.getId()).isPresent();
        if (existe) {
            ClienteEntity clienteEntity = new ClienteEntity(cliente);
            repository.save(clienteEntity);
        }
        else {
            throw new EntityNotFoundException("Erro ao atualizar cliente, o mesmo não existe.");
        }
    }

    public void excluirCliente(Long id) {
        boolean existe = repository.findById(id).isPresent();
        if (existe) {
            ClienteEntity cliente = repository.findById(id).get();
            repository.delete(cliente);
        }
        throw new EntityNotFoundException("Erro ao excluir agendamento com o id: " + id);
    }


}
