package com.samcancode.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import com.samcancode.sfgpetclinic.model.Pet;
import com.samcancode.sfgpetclinic.services.PetService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

}
