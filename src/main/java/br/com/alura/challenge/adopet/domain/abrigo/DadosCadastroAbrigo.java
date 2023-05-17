package br.com.alura.challenge.adopet.domain.abrigo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAbrigo(
        @NotBlank String nome,

        @NotBlank String login,

        @NotBlank String senha,
        @NotBlank @Email String email,
        @NotBlank String telefone) {
}
