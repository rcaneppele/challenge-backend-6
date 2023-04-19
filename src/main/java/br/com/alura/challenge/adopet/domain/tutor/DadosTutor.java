package br.com.alura.challenge.adopet.domain.tutor;

public record DadosTutor(Long id, String nome) {

    public DadosTutor(Tutor tutor) {
        this(tutor.getId(), tutor.getNome());
    }
}
