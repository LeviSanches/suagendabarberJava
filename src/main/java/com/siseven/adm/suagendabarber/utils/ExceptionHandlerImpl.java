package com.siseven.adm.suagendabarber.utils;

import com.siseven.adm.suagendabarber.services.exceptions.EntityNotFoundException;
import com.siseven.adm.suagendabarber.services.exceptions.InvalidArgumentException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
@ControllerAdvice
public class ExceptionHandlerImpl {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardResponseError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
        StandardResponseError erro = new StandardResponseError();
        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setMensagem(e.getMessage());
        erro.setErro("Resource not found");
        erro.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<StandardResponseError> invalidArgument(InvalidArgumentException e, HttpServletRequest request) {
        StandardResponseError erro = new StandardResponseError();
        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.BAD_REQUEST.value());
        erro.setMensagem(e.getMessage());
        erro.setErro("Invalid Argument");
        erro.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}