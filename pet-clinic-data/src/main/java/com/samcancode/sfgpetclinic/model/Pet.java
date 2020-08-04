package com.samcancode.sfgpetclinic.model;

import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="pets")
public class Pet extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="type_id")
	private PetType petType;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="pet")
	private final Set<Visit> visits = new HashSet<>();
	
	@Override
	public String toString() {
		return "Pet [id="+ getId() + ", name=" + name + ", petType=" + petType + ", owner=" + owner + ", birthDate=" + birthDate + "]";
	}

	@Builder
	public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate) {
		super(id);
		this.name = name;
		this.petType = petType;
		this.owner = owner;
		this.birthDate = birthDate;
	}
	
	public Pet() {}
}
