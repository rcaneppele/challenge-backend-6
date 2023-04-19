package br.com.alura.challenge.adopet.domain.adocao;

import br.com.alura.challenge.adopet.domain.abrigo.Abrigo;
import br.com.alura.challenge.adopet.domain.pet.DadosAtualizacaoPet;
import br.com.alura.challenge.adopet.domain.pet.DadosCadastroPet;
import br.com.alura.challenge.adopet.domain.pet.Pet;
import br.com.alura.challenge.adopet.domain.tutor.Tutor;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "data"})
@NoArgsConstructor
@Entity
@Table(name = "adocoes")
public class Adocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    public Adocao(DadosCadastroAdocao dados, Pet pet, Tutor tutor) {
        this.data = dados.data();
        this.pet = pet;
        this.tutor = tutor;
    }

}
