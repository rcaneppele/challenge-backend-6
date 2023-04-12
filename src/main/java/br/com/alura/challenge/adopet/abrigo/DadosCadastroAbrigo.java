package br.com.alura.challenge.adopet.abrigo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAbrigo(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank String telefone) {
}
