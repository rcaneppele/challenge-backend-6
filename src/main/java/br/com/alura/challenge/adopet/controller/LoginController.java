package br.com.alura.challenge.adopet.controller;

import br.com.alura.challenge.adopet.domain.usuario.DadosLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody DadosLogin dados) {
        var dadosLoginSpring = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        authenticationManager.authenticate(dadosLoginSpring);

        return ResponseEntity.ok().build();
    }

}
