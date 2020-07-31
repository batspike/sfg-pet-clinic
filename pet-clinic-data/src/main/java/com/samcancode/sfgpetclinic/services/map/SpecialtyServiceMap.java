package com.samcancode.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import com.samcancode.sfgpetclinic.model.Specialty;
import com.samcancode.sfgpetclinic.services.SpecialtyService;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {

}
