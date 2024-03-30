package com.jmachicado.vetapp.pet.application.create;

import com.jmachicado.vetapp.pet.domain.model.Pet;
import com.jmachicado.vetapp.pet.domain.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetCreateUseCaseImpl implements PetCreateUseCase {

  private final PetRepository petRepository;

  @Override
  public void execute(PetCreateRequest request) {
    Pet pet = new Pet();
    pet.setName(request.getName());
    pet.setBreed(request.getBreed());
    pet.setDateOfBirth(request.getDateOfBirth());
    pet.setIsVaccinated(request.getIsVaccinated());
    pet.setColor(request.getColor());
    pet.setOwnerName(request.getOwnerName());
    pet.setOwnerPhoneNumber(request.getOwnerPhoneNumber());
    petRepository.save(pet);
  }

}
