package com.samcancode.sfgpetclinic.services;

import com.samcancode.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	Owner findByLastName(String lastName);
}
