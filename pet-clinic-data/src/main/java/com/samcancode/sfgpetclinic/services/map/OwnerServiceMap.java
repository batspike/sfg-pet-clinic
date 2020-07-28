package com.samcancode.sfgpetclinic.services.map;

import com.samcancode.sfgpetclinic.model.Owner;
import com.samcancode.sfgpetclinic.services.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

	@Override
	public Owner findByLastName(String lastName) {
		return this.findAll().stream()
				.filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
				.findFirst()
				.orElse(null);
	}

}
