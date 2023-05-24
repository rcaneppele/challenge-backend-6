package br.com.alura.challenge.adopet.domain.tutor;

import br.com.alura.challenge.adopet.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "nome", "email"})
@NoArgsConstructor
@Entity
@Table(name = "tutores")
public class Tutor extends Usuario {

    private String nome;


    public Tutor(DadosCadastroTutor dados, String senhaBcrypt) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.login = dados.login();
        this.senha = senhaBcrypt;
    }

    public void atualizarDados(DadosAtualizacaoTutor dados) {
        this.nome = dados.nome() != null ? dados.nome() : this.nome;
        this.email = dados.email() != null ? dados.email() : this.email;
    }

}
