package br.com.alura.challenge.adopet.infra.security;

import br.com.alura.challenge.adopet.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class JWTService {

    @Value("{api.jwt.secret}")
    private String senha;
    @Value("{api.jwt.issuer}")
    private String issuer;

    public String gerarToken(Authentication authentication) {
        try {
            var usuario = (Usuario)authentication.getPrincipal();
            var algorithm = Algorithm.HMAC256(senha);
            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(usuario.getId().toString())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token");
        }
    }

    public Long getSubject(String jwt) {
        try {
            var algorithm = Algorithm.HMAC256(senha);
            return Long.parseLong(JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(jwt)
                    .getSubject());
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token invalido ou expirado: " +jwt);
        }
    }

}
