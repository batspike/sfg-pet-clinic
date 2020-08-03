package com.samcancode.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.samcancode.sfgpetclinic.model.Specialty;
import com.samcancode.sfgpetclinic.services.SpecialtyService;

@Service
@Profile({"default","map"})
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {

}
