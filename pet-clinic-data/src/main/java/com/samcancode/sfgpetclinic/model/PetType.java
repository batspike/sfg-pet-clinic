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
@Table(name="types")
public class PetType extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="name")
	private String name;

	@Builder
	public PetType(Long id, String name) {
		super(id);
		this.name = name;
	}

	public PetType() {}
}
