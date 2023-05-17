package br.com.alura.challenge.adopet.domain.abrigo;

import br.com.alura.challenge.adopet.domain.usuario.Usuario;
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
public class Abrigo extends Usuario {

    private String nome;
    private String telefone;

    public Abrigo(DadosCadastroAbrigo dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.login = dados.login();
        this.senha = dados.senha();
    }

    public void atualizarDados(DadosAtualizacaoAbrigo dados) {
        this.nome = dados.nome() != null ? dados.nome() : this.nome;
        this.email = dados.email() != null ? dados.email() : this.email;
        this.telefone = dados.telefone() != null ? dados.telefone() : this.telefone;
    }

}
