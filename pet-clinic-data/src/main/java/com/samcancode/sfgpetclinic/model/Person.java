package com.samcancode.sfgpetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class Person extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="fist_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	public Person(Long id, String firstName, String lastName) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person() {
	}

	
}
