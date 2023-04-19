package br.com.alura.challenge.adopet.controller;

import br.com.alura.challenge.adopet.domain.abrigo.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/abrigos")
public class AbrigosController {

    @Autowired
    private AbrigoRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAbrigo dados) {
        var abrigo = new Abrigo(dados);
        repository.save(abrigo);

        return ResponseEntity.ok(new DadosAbrigo(abrigo));
    }

    @GetMapping
    public ResponseEntity listar() {
        var abrigos = repository.findAll();
        if (abrigos.isEmpty()) {
            return ResponseEntity.ok("Não encontrado");
        }

        return ResponseEntity.ok(abrigos.stream().map(DadosDetalhesAbrigo::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        try {
            var abrigo = repository.getReferenceById(id);
            return ResponseEntity.ok(new DadosDetalhesAbrigo(abrigo));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("Não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok("abrigo apagado com sucesso!");
        }

        return ResponseEntity.ok("abrigo não encontrado!");
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH})
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAbrigo dados) {
        try {
            var abrigo = repository.getReferenceById(dados.id());
            abrigo.atualizarDados(dados);

            return ResponseEntity.ok(new DadosAbrigo(abrigo));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("abrigo não encontrado!");
        }
    }

}
