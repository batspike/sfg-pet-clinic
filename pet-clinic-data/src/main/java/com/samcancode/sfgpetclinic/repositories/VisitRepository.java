package com.samcancode.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.samcancode.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
