package com.samcancode.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="specialties")
public class Specialty extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="desciption")
	private String description;

	@Override
	public String toString() {
		return "Specialty [id="+ getId() + " : " + description + "]";
	}

	@Builder
	public Specialty(Long id, String description) {
		super(id);
		this.description = description;
	}
	
	public Specialty() {}
}
