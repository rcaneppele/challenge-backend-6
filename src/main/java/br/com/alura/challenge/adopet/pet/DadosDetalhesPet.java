package br.com.alura.challenge.adopet.pet;

import br.com.alura.challenge.adopet.tutor.Tutor;

public record DadosDetalhesPet(Long id, String nome, String descricao, String idade, Boolean adotado) {

    public DadosDetalhesPet(Pet pet) {
        this(pet.getId(), pet.getNome(), pet.getDescricao(), pet.getIdade(), pet.getAdotado());
    }

}
