package br.com.alura.challenge.adopet.domain.pet;

public record DadosPet(Long id, String nome) {

    public DadosPet(Pet pet) {
        this(pet.getId(), pet.getNome());
    }
}
