package com.samcancode.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import com.samcancode.sfgpetclinic.model.Vet;
import com.samcancode.sfgpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

}
