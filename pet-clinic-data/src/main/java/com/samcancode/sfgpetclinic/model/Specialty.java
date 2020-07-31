package com.samcancode.sfgpetclinic.model;

public class Specialty extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Specialty [id="+ getId() + " : " + description + "]";
	}
	
	
}
