package com.samcancode.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.samcancode.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
