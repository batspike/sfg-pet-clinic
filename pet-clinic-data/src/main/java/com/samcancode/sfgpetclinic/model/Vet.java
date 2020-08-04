package com.samcancode.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="vets")
public class Vet extends Person {
	public Vet() {}
	
	@Builder
	public Vet(Long id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

	private static final long serialVersionUID = 1L;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(	name="vet_specialties", 
				joinColumns=@JoinColumn(name="vet_id"), 
				inverseJoinColumns=@JoinColumn(name="specialty_id") )
	private final Set<Specialty> specialties = new HashSet<>();

	@Override
	public String toString() {
		return "Vet [id=" + this.getId() + ", Name: "+ getFirstName() + " "+ getLastName() + ", " + specialties + "]";
	}
	
}
