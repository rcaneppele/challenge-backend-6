package br.com.alura.challenge.adopet.domain.abrigo;

public record DadosDetalhesAbrigo(Long id, String nome, String telefone, String email) {

    public DadosDetalhesAbrigo(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome(), abrigo.getTelefone(), abrigo.getEmail());
    }

}
