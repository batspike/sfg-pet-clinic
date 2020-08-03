package com.samcancode.sfgpetclinic.services.springjpadb;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.samcancode.sfgpetclinic.model.Specialty;
import com.samcancode.sfgpetclinic.repositories.SpecialtyRepository;
import com.samcancode.sfgpetclinic.services.SpecialtyService;

@Service
@Profile("springdbjpa")
public class SpecialtyServiceJpaDb implements SpecialtyService {
	private final SpecialtyRepository specialtyRepo;
	public SpecialtyServiceJpaDb(SpecialtyRepository specialtyRepo) {
		this.specialtyRepo = specialtyRepo;
	}
	
	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> pets = new HashSet<>();
		specialtyRepo.findAll().forEach(pets::add);
		return pets;
	}
	
	@Override
	public Specialty findById(Long id) {
		return specialtyRepo.findById(id).orElse(null);
	}
	
	@Override
	public Specialty save(Specialty specialty) {
		return specialtyRepo.save(specialty);
	}
	
	@Override
	public void delete(Specialty specialty) {
		specialtyRepo.delete(specialty);
	}
	
	@Override
	public void deleteById(Long id) {
		specialtyRepo.deleteById(id);
	}
	
	
}
