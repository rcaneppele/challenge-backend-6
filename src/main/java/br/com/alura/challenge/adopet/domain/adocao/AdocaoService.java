package br.com.alura.challenge.adopet.domain.adocao;

import br.com.alura.challenge.adopet.domain.pet.PetRepository;
import br.com.alura.challenge.adopet.domain.tutor.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdocaoService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private AdocaoRepository adocaoRepository;

    public Adocao cadastraAdocao(DadosCadastroAdocao dados) {
        var pet = petRepository.findById(dados.petId()).orElseThrow(() -> new IllegalArgumentException("Pet não cadastrado!"));
        if (pet.getAdotado()) {
            throw new IllegalArgumentException("Pet já adotado!");
        }

        var tutor = tutorRepository.findById(dados.tutorId()).orElseThrow(() -> new IllegalArgumentException("tutor não cadastrado!"));

        var adocao = new Adocao(dados, pet, tutor);
        adocaoRepository.save(adocao);

        pet.marcarComoAdotado();

        return adocao;
    }

    public void apagarAdocao(Long id) {
        var adocao = adocaoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Adoção não cadastrada!"));
        adocaoRepository.deleteById(id);
    }
}
