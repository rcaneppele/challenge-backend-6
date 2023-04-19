package br.com.alura.challenge.adopet.domain.adocao;

import java.time.LocalDate;

public record DadosCadastroAdocao(Long petId, Long tutorId, LocalDate data) {
}
