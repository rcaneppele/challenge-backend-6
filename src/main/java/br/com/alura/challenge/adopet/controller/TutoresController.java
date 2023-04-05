package br.com.alura.challenge.adopet.controller;

import br.com.alura.challenge.adopet.tutor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/tutores")
public class TutoresController {

    @Autowired
    private TutorRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTutor dados) {
        if (!dados.senha().equals(dados.confirmacaoSenha())) {
            return ResponseEntity.badRequest().body("Senha e confirmação senha não conferem!");
        }

        var tutor = new Tutor(dados);
        repository.save(tutor);

        return ResponseEntity.ok(new DadosTutor(tutor));
    }

    @GetMapping
    public ResponseEntity listar() {
        var tutores = repository.findAll();
        if (tutores.isEmpty()) {
            return ResponseEntity.ok("Não encontrado");
        }

        return ResponseEntity.ok(tutores.stream().map(DadosDetalhesTutor::new).collect(Collectors.toList()));
    }

}
