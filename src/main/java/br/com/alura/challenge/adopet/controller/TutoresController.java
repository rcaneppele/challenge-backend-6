package br.com.alura.challenge.adopet.controller;

import br.com.alura.challenge.adopet.tutor.DadosCadastroTutor;
import br.com.alura.challenge.adopet.tutor.DadosTutor;
import br.com.alura.challenge.adopet.tutor.Tutor;
import br.com.alura.challenge.adopet.tutor.TutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
