package br.com.alura.challenge.adopet.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TratadorDeExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity tratarErroDeValidacao(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(new DadosErro400(LocalDateTime.now(), ex.getMessage()));
    }

    private record DadosErro400(LocalDateTime timestamp, String message) {}

}
