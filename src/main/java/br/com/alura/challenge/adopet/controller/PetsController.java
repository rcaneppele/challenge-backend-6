package br.com.alura.challenge.adopet.controller;

import br.com.alura.challenge.adopet.abrigo.*;
import br.com.alura.challenge.adopet.pet.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/pets")
public class PetsController {

    @Autowired
    private AbrigoRepository abrigoRepository;

    @Autowired
    private PetRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPet dados) {
        var abrigo = abrigoRepository.getReferenceById(dados.idAbrigo());

        var pet = new Pet(dados, abrigo);
        repository.save(pet);

        return ResponseEntity.ok(new DadosPet(pet));
    }

    @GetMapping
    public ResponseEntity listar() {
        var pets = repository.findAll();
        if (pets.isEmpty()) {
            return ResponseEntity.ok("Não encontrado");
        }

        return ResponseEntity.ok(pets.stream().map(DadosDetalhesPet::new).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        try {
            var pet = repository.getReferenceById(id);
            return ResponseEntity.ok(new DadosDetalhesPet(pet));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("Não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok("pet apagado com sucesso!");
        }

        return ResponseEntity.ok("pet não encontrado!");
    }

    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH})
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPet dados) {
        try {
            Abrigo abrigo = null;
            if (dados.idAbrigo() != null) {
                abrigo = abrigoRepository.getReferenceById(dados.idAbrigo());
            }
            var pet = repository.getReferenceById(dados.id());
            pet.atualizarDados(dados, abrigo);

            return ResponseEntity.ok(new DadosPet(pet));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.ok("pet não encontrado!");
        }
    }

}
