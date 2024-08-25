package com.siseven.adm.suagendabarber.entities;

import java.util.List;

import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.siseven.adm.suagendabarber.dto.ProfissionalDTO;

@Entity
@Table(name = "tb_profissional")
public class ProfissionalEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = true)
	private String senha;

	@OneToMany(mappedBy = "profissional")
	private List<AgendamentoEntity> agendamentos;

	public ProfissionalEntity() {}	

	public ProfissionalEntity(ProfissionalDTO profissional) {
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

	public List<AgendamentoEntity> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<AgendamentoEntity> agendamentos) {
		this.agendamentos = agendamentos;
	}
	
	
	

}
