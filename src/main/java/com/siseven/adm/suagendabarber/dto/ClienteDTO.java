package com.siseven.adm.suagendabarber.dto;


import com.siseven.adm.suagendabarber.entities.ClienteEntity;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.List;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String genero;
    private LocalDate dataNascimento;
    private String caminhoImagemPerfil;
    private String senha;

    private List<AgendamentoDTO> agendamentos;

    public ClienteDTO() {}

    public ClienteDTO(Long id) {
        this.id = id;
    }
    public ClienteDTO(ClienteEntity cliente) {
        BeanUtils.copyProperties(cliente, this);
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCaminhoImagemPerfil() {
        return caminhoImagemPerfil;
    }

    public void setCaminhoImagemPerfil(String caminhoImagemPerfil) {
        this.caminhoImagemPerfil = caminhoImagemPerfil;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<AgendamentoDTO> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<AgendamentoDTO> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
