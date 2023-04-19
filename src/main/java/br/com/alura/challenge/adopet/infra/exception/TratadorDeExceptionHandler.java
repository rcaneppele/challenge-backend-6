package br.com.alura.challenge.adopet.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity tratarErroDeValidacao(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
