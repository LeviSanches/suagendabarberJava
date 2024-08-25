package com.siseven.adm.suagendabarber.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.siseven.adm.suagendabarber.dto.ClienteDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String caminhoImagemPerfil;

    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "cliente")
    private List<AgendamentoEntity> agendamentos;

    public ClienteEntity() {}

    public ClienteEntity(ClienteDTO cliente) {
        BeanUtils.copyProperties(cliente, this);
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

    public List<AgendamentoEntity> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<AgendamentoEntity> agendamentos) {
        this.agendamentos = agendamentos;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
