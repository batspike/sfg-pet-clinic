package com.samcancode.sfgpetclinic.services.springjpadb;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.samcancode.sfgpetclinic.model.PetType;
import com.samcancode.sfgpetclinic.repositories.PetTypeRepository;
import com.samcancode.sfgpetclinic.services.PetTypeService;

@Service
@Profile("springdbjpa")
public class PetTypeServiceJpaDb implements PetTypeService {
	private final PetTypeRepository petTypeRepo;
	public PetTypeServiceJpaDb(PetTypeRepository petTypeRepo) {
		this.petTypeRepo = petTypeRepo;
	}
	
	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepo.findAll().forEach(petTypes::add);
		return petTypes;
	}
	
	@Override
	public PetType findById(Long id) {
		return petTypeRepo.findById(id).orElse(null);
	}
	
	@Override
	public PetType save(PetType petType) {
		return petTypeRepo.save(petType);
	}
	
	@Override
	public void delete(PetType petType) {
		petTypeRepo.delete(petType);
	}
	
	@Override
	public void deleteById(Long id) {
		petTypeRepo.deleteById(id);
	}
	
	
}
