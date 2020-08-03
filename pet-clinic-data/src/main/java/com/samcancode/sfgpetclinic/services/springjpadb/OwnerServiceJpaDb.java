package com.samcancode.sfgpetclinic.services.springjpadb;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.samcancode.sfgpetclinic.model.Owner;
import com.samcancode.sfgpetclinic.repositories.OwnerRepository;
import com.samcancode.sfgpetclinic.services.OwnerService;

@Service
@Profile("springdbjpa")
public class OwnerServiceJpaDb implements OwnerService {
	private final OwnerRepository ownerRepo;
	public OwnerServiceJpaDb(OwnerRepository ownerRepo) {
		this.ownerRepo = ownerRepo;
	}
	
	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepo.findByLastName(lastName);
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepo.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepo.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner owner) {
		return ownerRepo.save(owner);
	}

	@Override
	public void delete(Owner owner) {
		 ownerRepo.delete(owner);
	}

	@Override
	public void deleteById(Long id) {
		 ownerRepo.deleteById(id);
	}
	
}
