package com.samcancode.sfgpetclinic.services.springjpadb;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.samcancode.sfgpetclinic.model.Pet;
import com.samcancode.sfgpetclinic.repositories.PetRepository;
import com.samcancode.sfgpetclinic.services.PetService;

@Service
@Profile("springdbjpa")
public class PetServiceJpaDb implements PetService {
	private final PetRepository petRepo;
	public PetServiceJpaDb(PetRepository petRepo) {
		this.petRepo = petRepo;
	}
	
	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepo.findAll().forEach(pets::add);
		return pets;
	}
	
	@Override
	public Pet findById(Long id) {
		return petRepo.findById(id).orElse(null);
	}
	
	@Override
	public Pet save(Pet pet) {
		return petRepo.save(pet);
	}
	
	@Override
	public void delete(Pet pet) {
		petRepo.delete(pet);
	}
	
	@Override
	public void deleteById(Long id) {
		petRepo.deleteById(id);
	}
	
	
}
