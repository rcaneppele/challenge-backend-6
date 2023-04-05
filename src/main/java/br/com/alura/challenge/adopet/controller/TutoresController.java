package br.com.alura.challenge.adopet.controller;

import br.com.alura.challenge.adopet.tutor.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        try {
            var tutor = repository.getReferenceById(id);
            return ResponseEntity.ok(new DadosDetalhesTutor(tutor));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("Não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok("tutor apagado com sucesso!");
        }

        return ResponseEntity.ok("tutor não encontrado!");
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH})
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTutor dados) {
        try {
            var tutor = repository.getReferenceById(dados.id());

            if (dados.senha() != null && (!dados.senha().equals(dados.confirmacaoSenha()))) {
                return ResponseEntity.badRequest().body("Senha e confirmação senha não conferem!");
            }
            tutor.atualizarDados(dados);

            return ResponseEntity.ok(new DadosTutor(tutor));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("tutor não encontrado!");
        }
    }

}
