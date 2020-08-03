package com.samcancode.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.samcancode.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	Owner findByLastName(String lastname);
}
