package com.siseven.adm.suagendabarber.dto;

import org.springframework.beans.BeanUtils;

import com.siseven.adm.suagendabarber.entities.ServicoEntity;

public class ServicoDTO {
	
	private Long id;

	private String nome;

	private Double valor;

	private Integer qtSlots;
	
	public ServicoDTO() {}
	
	public ServicoDTO(ServicoEntity servico) {
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

}
