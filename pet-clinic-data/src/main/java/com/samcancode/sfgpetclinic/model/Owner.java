package com.samcancode.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="owners")
public class Owner extends Person {
	private static final long serialVersionUID = 1L;

	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="telephone")
	private String telephone;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
	private final Set<Pet> pets = new HashSet<>();

	@Override
	public String toString() {
		return "Owner [Id=" + getId() + ", Name="+ getFirstName() + " " + getLastName() + ", address=" + address + ", city=" + city + ", telephone=" + telephone + ", pets=" + pets + "]";
	}

	@Builder
	public Owner(Long id, String firstName, String lastName, String address, String city, String telephone) {
		super(id, firstName, lastName);
		this.address = address;
		this.city = city;
		this.telephone = telephone;
	}

	public Owner() {}
	
}
