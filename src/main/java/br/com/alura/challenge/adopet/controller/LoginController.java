package br.com.alura.challenge.adopet.controller;

import br.com.alura.challenge.adopet.domain.usuario.DadosLogin;
import br.com.alura.challenge.adopet.infra.security.JWTService;
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

    @Autowired
    private JWTService jwtService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody DadosLogin dados) {
        var dadosLoginSpring = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = authenticationManager.authenticate(dadosLoginSpring);
        var jwt = jwtService.gerarToken(authentication);

        return ResponseEntity.ok(jwt);
    }

}
