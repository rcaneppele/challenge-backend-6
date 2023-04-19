package br.com.alura.challenge.adopet.domain.abrigo;

public record DadosAbrigo(Long id, String nome) {

    public DadosAbrigo(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome());
    }

}
