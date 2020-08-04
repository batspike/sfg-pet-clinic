package com.samcancode.sfgpetclinic.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="visits")
public class Visit extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="pet_id")
	private Pet pet;

	@Builder
	public Visit(Long id, LocalDate date, String description, Pet pet) {
		super(id);
		this.date = date;
		this.description = description;
		this.pet = pet;
	}

	public Visit() {
	}
	
}
