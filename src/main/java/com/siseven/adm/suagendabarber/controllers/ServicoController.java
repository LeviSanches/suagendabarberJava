package com.siseven.adm.suagendabarber.controllers;

import com.siseven.adm.suagendabarber.utils.ResponseUtil;
import com.siseven.adm.suagendabarber.utils.StandardResponseSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.siseven.adm.suagendabarber.dto.ServicoDTO;
import com.siseven.adm.suagendabarber.services.impl.ServicoService;

@RestController
@RequestMapping(value = "/servico")
public class ServicoController {

	@Autowired
	ServicoService servicoService;

	@GetMapping
	public ResponseEntity<StandardResponseSuccess> obterServicos() {
		return ResponseUtil.respostaPadraoSucesso("Sucesso", HttpStatus.OK, servicoService.obterServicosCadastrados());
	}

	@PostMapping
	public ResponseEntity<StandardResponseSuccess> inserirServico(@RequestBody ServicoDTO servico) {
		servicoService.incluirServico(servico);
		return ResponseUtil.respostaPadraoSucesso("Criado com sucesso!", HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<StandardResponseSuccess> atualizarServico(@RequestBody ServicoDTO servico) {
		servicoService.incluirServico(servico);
		return ResponseUtil.respostaPadraoSucesso("Atualizado com sucesso!", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<StandardResponseSuccess> excluirServico(@PathVariable Long id) {
		servicoService.deletarServico(id);
		return ResponseUtil.respostaPadraoSucesso("Deletado com sucesso!", HttpStatus.OK);
	}

}
