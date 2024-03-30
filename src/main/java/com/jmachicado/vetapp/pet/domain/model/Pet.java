package com.jmachicado.vetapp.pet.domain.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Pet {

  private Long id;
  private String name;
  private String breed;
  private String color;
  private String ownerName;
  private String ownerPhoneNumber;
  private LocalDate dateOfBirth;
  private Boolean isVaccinated;
}
