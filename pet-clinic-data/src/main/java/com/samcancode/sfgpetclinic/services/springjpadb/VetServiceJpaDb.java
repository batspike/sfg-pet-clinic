package com.samcancode.sfgpetclinic.services.springjpadb;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.samcancode.sfgpetclinic.model.Vet;
import com.samcancode.sfgpetclinic.repositories.VetRepository;
import com.samcancode.sfgpetclinic.services.VetService;

@Service
@Profile("springdbjpa")
public class VetServiceJpaDb implements VetService {
	private final VetRepository vetRepo;
	public VetServiceJpaDb(VetRepository vetRepo) {
		this.vetRepo = vetRepo;
	}
	
	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepo.findAll().forEach(vets::add);
		return vets;
	}
	
	@Override
	public Vet findById(Long id) {
		return vetRepo.findById(id).orElse(null);
	}
	
	@Override
	public Vet save(Vet vet) {
		return vetRepo.save(vet);
	}
	
	@Override
	public void delete(Vet vet) {
		vetRepo.delete(vet);
	}
	
	@Override
	public void deleteById(Long id) {
		vetRepo.deleteById(id);
	}
	
	
}
