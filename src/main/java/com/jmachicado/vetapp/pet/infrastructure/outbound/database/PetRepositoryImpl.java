package com.jmachicado.vetapp.pet.infrastructure.outbound.database;

import com.jmachicado.vetapp.pet.domain.model.Pet;
import com.jmachicado.vetapp.pet.domain.repository.PetRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PetRepositoryImpl implements PetRepository {

  private final PetJpaRepository petJpaRepository;

  @Override
  public void save(Pet pet) {
    PetEntity petEntity = new PetEntity();
    petEntity.setId(pet.getId());
    petEntity.setName(pet.getName());
    petEntity.setBreed(pet.getBreed());
    petEntity.setColor(pet.getColor());
    petEntity.setOwnerName(pet.getOwnerName());
    petEntity.setOwnerPhoneNumber(pet.getOwnerPhoneNumber());
    petEntity.setDateOfBirth(pet.getDateOfBirth());
    petEntity.setIsVaccinated(pet.getIsVaccinated());

    petJpaRepository.save(petEntity);
  }

  @Override
  public Optional<Pet> findById(Long id) {
    Optional<PetEntity> petEntity = petJpaRepository.findById(id);
    if (petEntity.isPresent()) {
      PetEntity petEntityValue = petEntity.get();
      Pet pet = new Pet();
      pet.setId(petEntityValue.getId());
      pet.setName(petEntityValue.getName());
      pet.setBreed(petEntityValue.getBreed());
      pet.setColor(petEntityValue.getColor());
      pet.setOwnerName(petEntityValue.getOwnerName());
      pet.setOwnerPhoneNumber(petEntityValue.getOwnerPhoneNumber());
      return Optional.of(pet);
    }
    return Optional.empty();
  }
}
