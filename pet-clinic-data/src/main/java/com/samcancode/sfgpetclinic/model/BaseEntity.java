package com.samcancode.sfgpetclinic.model;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass //tells JPA to treat this as ordinary class, not entity
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	public BaseEntity(Long id) {
		super();
		this.id = id;
	}

	public BaseEntity() {
		super();
	}

}
