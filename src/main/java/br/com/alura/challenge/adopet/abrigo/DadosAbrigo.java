package br.com.alura.challenge.adopet.abrigo;

import br.com.alura.challenge.adopet.abrigo.Abrigo;

public record DadosAbrigo(Long id, String nome) {

    public DadosAbrigo(Abrigo abrigo) {
        this(abrigo.getId(), abrigo.getNome());
    }

}
