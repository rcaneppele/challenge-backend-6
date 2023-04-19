package br.com.alura.challenge.adopet.domain.pet;

public record DadosAtualizacaoPet(Long id, String nome, String descricao, String idade, Boolean adotado, String imagem, Long idAbrigo) {
}
