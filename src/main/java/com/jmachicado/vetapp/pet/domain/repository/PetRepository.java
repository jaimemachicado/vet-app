package com.jmachicado.vetapp.pet.domain.repository;

import com.jmachicado.vetapp.pet.domain.model.Pet;
import java.util.Optional;

public interface PetRepository {

  void save(Pet pet);

  Optional<Pet> findById(Long id);
}
