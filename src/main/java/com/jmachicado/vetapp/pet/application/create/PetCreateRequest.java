package com.jmachicado.vetapp.pet.application.create;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PetCreateRequest {

  private String name;
  private String breed;
  private LocalDate dateOfBirth;
  private Boolean isVaccinated;
  private String color;
  private String ownerName;
  private String ownerPhoneNumber;
}
