package br.com.alura.challenge.adopet.tutor;

public record DadosTutor(Long id, String nome) {

    public DadosTutor(Tutor tutor) {
        this(tutor.getId(), tutor.getNome());
    }
}
