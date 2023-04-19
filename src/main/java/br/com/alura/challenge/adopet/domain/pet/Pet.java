package br.com.alura.challenge.adopet.domain.pet;

import br.com.alura.challenge.adopet.domain.abrigo.Abrigo;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "nome", "descricao"})
@NoArgsConstructor
@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    private Boolean adotado;

    private String imagem;

    private String idade;

    @ManyToOne
    @JoinColumn(name = "abrigo_id")
    private Abrigo abrigo;

    public Pet(DadosCadastroPet dados, Abrigo abrigo) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.adotado = dados.adotado();
        this.imagem = dados.imagem();
        this.idade = dados.idade();
        this.abrigo = abrigo;
    }

    public void atualizarDados(DadosAtualizacaoPet dados, Abrigo abrigo) {
        this.nome = dados.nome() != null ? dados.nome() : this.nome;
        this.descricao = dados.descricao() != null ? dados.descricao() : this.descricao;
        this.adotado = dados.adotado() != null ? dados.adotado() : this.adotado;
        this.imagem = dados.imagem() != null ? dados.imagem() : this.imagem;
        this.idade = dados.idade() != null ? dados.idade() : this.idade;
        this.abrigo = abrigo != null ? abrigo : this.abrigo;
    }

    public void marcarComoAdotado() {
        this.adotado = true;
    }
}
