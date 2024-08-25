package com.siseven.adm.suagendabarber.entities;

import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import com.siseven.adm.suagendabarber.dto.ServicoDTO;

import java.util.List;

@Entity
@Table(name = "tb_servico")
public class ServicoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private Double valor;

	@Column(nullable = false)
	private Integer qtSlots;

	@OneToMany(mappedBy = "servico")
	private List<AgendamentoEntity> agendamentos;
	
	public ServicoEntity() {}

	public ServicoEntity(ServicoDTO servico) {
		BeanUtils.copyProperties(servico, this);
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQtSlots() {
		return qtSlots;
	}

	public void setQtSlots(Integer qtSlots) {
		this.qtSlots = qtSlots;
	}

	public List<AgendamentoEntity> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<AgendamentoEntity> agendamentos) {
		this.agendamentos = agendamentos;
	}
}
