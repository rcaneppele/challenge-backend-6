package br.com.alura.challenge.adopet.abrigo;

import br.com.alura.challenge.adopet.tutor.DadosAtualizacaoTutor;
import br.com.alura.challenge.adopet.tutor.DadosCadastroTutor;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "nome", "email", "telefone"})
@NoArgsConstructor
@Entity
@Table(name = "abrigos")
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;

    public Abrigo(DadosCadastroAbrigo dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
    }

    public void atualizarDados(DadosAtualizacaoAbrigo dados) {
        this.nome = dados.nome() != null ? dados.nome() : this.nome;
        this.email = dados.email() != null ? dados.email() : this.email;
        this.telefone = dados.telefone() != null ? dados.telefone() : this.telefone;
    }

}
