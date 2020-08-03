package com.samcancode.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.samcancode.sfgpetclinic.model.Owner;
import com.samcancode.sfgpetclinic.model.Pet;
import com.samcancode.sfgpetclinic.model.PetType;
import com.samcancode.sfgpetclinic.model.Specialty;
import com.samcancode.sfgpetclinic.model.Vet;
import com.samcancode.sfgpetclinic.model.Visit;
import com.samcancode.sfgpetclinic.services.OwnerService;
import com.samcancode.sfgpetclinic.services.PetService;
import com.samcancode.sfgpetclinic.services.PetTypeService;
import com.samcancode.sfgpetclinic.services.SpecialtyService;
import com.samcancode.sfgpetclinic.services.VetService;
import com.samcancode.sfgpetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final PetService petService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;
	public DataLoader(OwnerService ownerService, 
					  VetService vetService, 
					  PetTypeService petTypeService,
					  PetService petService,
					  SpecialtyService specialtyService,
					  VisitService visitService ) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.petService = petService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}


	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size();
		if(count == 0) {
			loadData();
		}
	}


	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		System.out.println("===================PetType Loaded.");
		
		Pet pet1 = new Pet();
		pet1.setBirthDate(LocalDate.now());
		pet1.setName("Lucky");
		pet1.setPetType(savedDogPetType);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("23 Flora Rd");
		owner1.setCity("Miami");
		owner1.setTelephone("2322322334");
		owner1.getPets().add(pet1);
		Owner savedOwner1 = ownerService.save(owner1);
		System.out.println("========================== owner1: "+ owner1);

		
		Pet pet2 = new Pet();
		pet2.setBirthDate(LocalDate.now());
		pet2.setName("Meowmy");
		pet2.setPetType(savedCatPetType);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("23 Chicken Rd");
		owner2.setCity("Tokyo");
		owner2.setTelephone("2322322334");
		owner2.getPets().add(pet2);
		Owner savedOwner2 = ownerService.save(owner2);
		System.out.println("========================== owner2: "+ owner2);
		
		System.out.println("=================Owners Loaded.");

		Visit catVisit = new Visit();
		catVisit.setPet(savedOwner2.getPets().iterator().next());
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy Kitty");
		visitService.save(catVisit);
		
		System.out.println("================ Visit Loaded.");
		
		
		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		Specialty savedRadiology = specialtyService.save(radiology);
		
		Specialty surgery = new Specialty();
		surgery.setDescription("Surgery");
		Specialty savedSurgery = specialtyService.save(surgery);
		
		Specialty dentistry = new Specialty();
		dentistry.setDescription("Dentistry");
		Specialty savedDentistry = specialtyService.save(dentistry);
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialties().add(savedRadiology);
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialties().add(savedSurgery);
		vetService.save(vet2);
		
		Vet vet3 = new Vet();
		vet3.setFirstName("Bob");
		vet3.setLastName("Castle");
		vet3.getSpecialties().add(savedDentistry);
		vetService.save(vet3);
		
		System.out.println("======================== vet1: "+ vet1);
		System.out.println("======================== vet2: "+ vet2);
		System.out.println("======================== vet3: "+ vet3);
		System.out.println("=================Vets Loaded.");
	}

}
