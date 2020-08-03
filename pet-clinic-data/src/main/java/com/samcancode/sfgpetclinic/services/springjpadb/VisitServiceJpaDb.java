package com.samcancode.sfgpetclinic.services.springjpadb;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.samcancode.sfgpetclinic.model.Visit;
import com.samcancode.sfgpetclinic.repositories.VisitRepository;
import com.samcancode.sfgpetclinic.services.VisitService;

@Service
@Profile("springdbjpa")
public class VisitServiceJpaDb implements VisitService {
	private final VisitRepository visitRepository;
	public VisitServiceJpaDb(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}
	
	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}
	
	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}
	
	@Override
	public Visit save(Visit visit) {
		return visitRepository.save(visit);
	}
	
	@Override
	public void delete(Visit visit) {
		visitRepository.delete(visit);
	}
	
	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}
	
	
}
