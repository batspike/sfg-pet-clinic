package com.samcancode.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.samcancode.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
