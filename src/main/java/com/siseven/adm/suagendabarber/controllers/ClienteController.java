package com.siseven.adm.suagendabarber.controllers;

import com.siseven.adm.suagendabarber.dto.ClienteDTO;
import com.siseven.adm.suagendabarber.services.impl.ClienteService;
import com.siseven.adm.suagendabarber.utils.ResponseUtil;
import com.siseven.adm.suagendabarber.utils.StandardResponseSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<StandardResponseSuccess> listarTodos() {
        return ResponseUtil
                .respostaPadraoSucesso("Resultado obtido com sucesso", HttpStatus.OK, service.listarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponseSuccess> buscarCliente(@PathVariable Long id) {
        return ResponseUtil
                .respostaPadraoSucesso("Resultado obtido com sucesso", HttpStatus.OK, service.buscarCliente(id));
    }

    @PostMapping
    public ResponseEntity<StandardResponseSuccess> inserirCliente(@RequestBody  ClienteDTO cliente) {
        service.incluirCliente(cliente);
        return ResponseUtil.respostaPadraoSucesso("Cliente cadastrado com sucesso", HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<StandardResponseSuccess> excluirCliente(Long id) {
        service.excluirCliente(id);
        return ResponseUtil.respostaPadraoSucesso("Cliente excluído com sucesso", HttpStatus.OK);
    }
}
