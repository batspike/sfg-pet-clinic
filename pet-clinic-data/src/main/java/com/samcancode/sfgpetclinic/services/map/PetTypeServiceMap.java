package com.samcancode.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import com.samcancode.sfgpetclinic.model.PetType;
import com.samcancode.sfgpetclinic.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

}
