package com.siseven.adm.suagendabarber.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.siseven.adm.suagendabarber.dto.AgendamentoDTO;

@Entity
@Table(name = "tb_agendamento")
public class AgendamentoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDate data;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClienteEntity cliente;

	@ManyToOne
	@JoinColumn(name = "id_servico")
	private ServicoEntity servico;

	@ManyToOne
	@JoinColumn(name = "id_profissional")
	private ProfissionalEntity profissional;

	public AgendamentoEntity() {}

	public AgendamentoEntity(AgendamentoDTO agendamento) {
		BeanUtils.copyProperties(agendamento, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteEntity getCliente() { return cliente; }

	public void setCliente(ClienteEntity cliente) { this.cliente = cliente; }

	public ServicoEntity getServico() { return servico; }

	public void setServico(ServicoEntity servico) { this.servico = servico; }

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public ProfissionalEntity getProfissional() {
		return profissional;
	}

	public void setProfissional(ProfissionalEntity profissional) {
		this.profissional = profissional;
	}	

}
