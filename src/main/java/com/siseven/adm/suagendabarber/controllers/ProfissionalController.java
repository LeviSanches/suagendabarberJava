package com.siseven.adm.suagendabarber.controllers;

import com.siseven.adm.suagendabarber.dto.ProfissionalDTO;
import com.siseven.adm.suagendabarber.services.impl.ProfissionalService;
import com.siseven.adm.suagendabarber.utils.ResponseUtil;
import com.siseven.adm.suagendabarber.utils.StandardResponseSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profissional")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @GetMapping
    public ResponseEntity<StandardResponseSuccess> obterProfissionais() {
        return ResponseUtil.respostaPadraoSucesso("Dados obtidos com exito", HttpStatus.OK, profissionalService.listarProfissionais());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponseSuccess> buscarProfissional(@PathVariable Long id) {
        return ResponseUtil.respostaPadraoSucesso("Dado obtido com exito", HttpStatus.OK, profissionalService.buscarProfissional(id));
    }

    @PostMapping
    public ResponseEntity<StandardResponseSuccess> incluirProfissional(@RequestBody ProfissionalDTO profissional) {
        profissionalService.incluirProfissional(profissional);
        return ResponseUtil.respostaPadraoSucesso("Incluido com sucesso", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<StandardResponseSuccess> atualizarProfissional(@RequestBody ProfissionalDTO profissional) {
        profissionalService.incluirProfissional(profissional);
        return ResponseUtil.respostaPadraoSucesso("Atualizado com sucesso", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponseSuccess> excluirProfissional(@PathVariable("id") Long id) {
        profissionalService.excluirProfissional(id);
        return ResponseUtil.respostaPadraoSucesso("Excluído com sucesso", HttpStatus.OK);
    }

}
