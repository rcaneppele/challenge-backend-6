package br.com.alura.challenge.adopet.pet;

import br.com.alura.challenge.adopet.tutor.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
