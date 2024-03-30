package com.jmachicado.vetapp.pet.infrastructure.inbound;

import com.jmachicado.vetapp.pet.application.create.PetCreateRequest;
import com.jmachicado.vetapp.pet.application.create.PetCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PetCreateController {

  private final PetCreateUseCase petCreateUseCase;

  @PostMapping("/pets")
  @ResponseStatus(HttpStatus.CREATED)
  public void createPet(@RequestBody PetCreateRequest request) {
    petCreateUseCase.execute(request);
  }

}
