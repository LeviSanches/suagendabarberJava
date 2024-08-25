package com.siseven.adm.suagendabarber.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.List;

public class ResponseUtil {

    public static ResponseEntity<StandardResponseSuccess> respostaPadraoSucesso(String msg, HttpStatus status) {
        StandardResponseSuccess res = new StandardResponseSuccess();
        res.setTimestamp(Instant.now());
        res.setStatus(status.value());
        res.setMensagem(msg);
        return ResponseEntity.status(status).body(res);
    }

    public static ResponseEntity<StandardResponseSuccess> respostaPadraoSucesso(String msg, HttpStatus status, List<?> lista) {
        StandardResponseSuccess res = new StandardResponseSuccess();
        res.setLista(lista);
        res.setTimestamp(Instant.now());
        res.setStatus(status.value());
        res.setMensagem(msg);
        return ResponseEntity.status(status).body(res);
    }
    public static ResponseEntity<StandardResponseSuccess> respostaPadraoSucesso(String msg, HttpStatus status, Object objeto) {
        StandardResponseSuccess res = new StandardResponseSuccess();
        res.setObjeto(objeto);
        res.setTimestamp(Instant.now());
        res.setStatus(status.value());
        res.setMensagem(msg);
        return ResponseEntity.status(status).body(res);
    }


}
