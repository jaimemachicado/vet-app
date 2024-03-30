package com.jmachicado.vetapp.pet.infrastructure.outbound.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetJpaRepository extends JpaRepository<PetEntity, Long> {

}
