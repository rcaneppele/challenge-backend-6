package br.com.alura.challenge.adopet.tutor;

public record DadosDetalhesTutor(Long id, String nome, String email) {

    public DadosDetalhesTutor(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getEmail());
    }

}
