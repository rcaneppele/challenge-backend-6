package br.com.alura.challenge.adopet.pet;

import br.com.alura.challenge.adopet.tutor.Tutor;

public record DadosPet(Long id, String nome) {

    public DadosPet(Pet pet) {
        this(pet.getId(), pet.getNome());
    }
}
