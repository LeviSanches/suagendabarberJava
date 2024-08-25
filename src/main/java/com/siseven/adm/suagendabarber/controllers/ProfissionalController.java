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
        return ResponseUtil.respostaPadraoSucesso("Sucesso", HttpStatus.OK, profissionalService.listarProfissionais());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> buscarProfissional(@PathVariable Long id) {
        ProfissionalDTO profissional = profissionalService.buscarProfissional(id);
        return ResponseEntity.ok(profissional);
    }

    @PostMapping
    public ResponseEntity<StandardResponseSuccess> incluirProfissional(@RequestBody ProfissionalDTO profissional) {
        profissionalService.incluirProfissional(profissional);
        return ResponseUtil.respostaPadraoSucesso("Sucesso", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponseSuccess> excluirProfissional(@PathVariable("id") Long id) {
        profissionalService.excluirProfissional(id);
        return ResponseUtil.respostaPadraoSucesso("Excluído com sucesso", HttpStatus.OK);
    }

}
