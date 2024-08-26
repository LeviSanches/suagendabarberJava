package com.siseven.adm.suagendabarber.controllers;

import java.time.LocalDate;
import java.util.List;

import com.siseven.adm.suagendabarber.dto.ProfissionalDTO;
import com.siseven.adm.suagendabarber.utils.ResponseUtil;
import com.siseven.adm.suagendabarber.utils.StandardResponseSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.siseven.adm.suagendabarber.dto.AgendamentoDTO;
import com.siseven.adm.suagendabarber.services.impl.AgendamentoService;

@RestController
@RequestMapping(value = "/agendamento")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@GetMapping
	public List<AgendamentoDTO> buscarTodos() {
		return agendamentoService.buscarTodos();
	}

	@GetMapping("/data")
	public List<AgendamentoDTO> buscarPorData(@RequestBody AgendamentoDTO data) {
		return agendamentoService.buscarTodosPorData(data);
	}

	@GetMapping("/profissional")
	public List<AgendamentoDTO> buscarPorProfissional(@RequestBody AgendamentoDTO profissional) {
		return agendamentoService.buscarPorProfissional(profissional);
	}

	@GetMapping("/profissional-data")
	public List<AgendamentoDTO> buscaPorProfissionalEData(@RequestBody AgendamentoDTO agendaPessoal) {
		return agendamentoService.buscarPorProfissionalEData(agendaPessoal);
	}

	@PostMapping
	public ResponseEntity<StandardResponseSuccess> inserirAgendamento(@RequestBody AgendamentoDTO agendamento) {
		agendamentoService.incluirAgendamento(agendamento);
		return ResponseUtil.respostaPadraoSucesso("Criado com sucesso!", HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<StandardResponseSuccess> atualizarAgendamento(@RequestBody AgendamentoDTO agendamento) {
		agendamentoService.atualizarAgendamento(agendamento);
		return ResponseUtil.respostaPadraoSucesso("Atualizado com sucesso!", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<StandardResponseSuccess> deletarAgendamento(@PathVariable Long id) {
		agendamentoService.excluirAgendamento(id);
		return ResponseUtil.respostaPadraoSucesso("Agendamento excluído com sucesso", HttpStatus.OK);
	}

}
