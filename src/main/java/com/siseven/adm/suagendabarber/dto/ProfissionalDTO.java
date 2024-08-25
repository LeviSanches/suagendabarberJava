package com.siseven.adm.suagendabarber.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.siseven.adm.suagendabarber.entities.AgendamentoEntity;
import com.siseven.adm.suagendabarber.entities.ProfissionalEntity;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class ProfissionalDTO {
    private Long id;
    private String nome;
    private String senha;
    private List<AgendamentoDTO> agendamento;

    public ProfissionalDTO() {}

    public ProfissionalDTO(ProfissionalEntity profissional) {
        BeanUtils.copyProperties(profissional, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<AgendamentoDTO> getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(List<AgendamentoDTO> agendamento) {
        this.agendamento = agendamento;
    }
}
