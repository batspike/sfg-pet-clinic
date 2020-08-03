package com.samcancode.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import com.samcancode.sfgpetclinic.model.Visit;
import com.samcancode.sfgpetclinic.services.VisitService;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

}
