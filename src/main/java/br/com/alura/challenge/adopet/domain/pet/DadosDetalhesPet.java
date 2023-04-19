package br.com.alura.challenge.adopet.domain.pet;

public record DadosDetalhesPet(Long id, String nome, String descricao, String idade, Boolean adotado) {

    public DadosDetalhesPet(Pet pet) {
        this(pet.getId(), pet.getNome(), pet.getDescricao(), pet.getIdade(), pet.getAdotado());
    }

}
