package com.siseven.adm.suagendabarber.dto;

import java.time.LocalDate;
import org.springframework.beans.BeanUtils;
import com.siseven.adm.suagendabarber.entities.AgendamentoEntity;


public class AgendamentoDTO {

	private Long id;
	private LocalDate data;
	private ClienteDTO cliente;
	private ServicoDTO servico;
	private ProfissionalDTO profissional;

	public AgendamentoDTO() {}

	public AgendamentoDTO(AgendamentoEntity agendamento) {
		BeanUtils.copyProperties(agendamento, this);
		cliente = new ClienteDTO(agendamento.getCliente());
		servico = new ServicoDTO(agendamento.getServico());
		profissional = new ProfissionalDTO(agendamento.getProfissional());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public ServicoDTO getServico() {
		return servico;
	}

	public void setServico(ServicoDTO servico) {
		this.servico = servico;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public ProfissionalDTO getProfissional() {
		return profissional;
	}

	public void setProfissional(ProfissionalDTO profissional) {
		this.profissional = profissional;
	}
}
