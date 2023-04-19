package br.com.alura.challenge.adopet.controller;

import br.com.alura.challenge.adopet.domain.abrigo.Abrigo;
import br.com.alura.challenge.adopet.domain.abrigo.AbrigoRepository;
import br.com.alura.challenge.adopet.domain.adocao.AdocaoService;
import br.com.alura.challenge.adopet.domain.adocao.DadosAdocao;
import br.com.alura.challenge.adopet.domain.adocao.DadosCadastroAdocao;
import br.com.alura.challenge.adopet.domain.pet.*;
import br.com.alura.challenge.adopet.domain.tutor.TutorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/adocao")
public class AdocaoController {

    @Autowired
    private AdocaoService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAdocao dados) {
        var adocao = service.cadastraAdocao(dados);

        return ResponseEntity.ok(new DadosAdocao(adocao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity apagar(@PathVariable Long id) {
        service.apagarAdocao(id);

        return ResponseEntity.ok("adoção removida!");
    }

}
