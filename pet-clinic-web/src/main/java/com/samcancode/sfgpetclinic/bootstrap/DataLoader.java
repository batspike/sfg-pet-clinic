package com.samcancode.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
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
	@SuppressWarnings("unused")
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


	@SuppressWarnings("unused")
	private void loadData() {
		PetType dog = PetType.builder().name("Dog").build();
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = PetType.builder().name("Cat").build();
		PetType savedCatPetType = petTypeService.save(cat);
		
		System.out.println("===================PetType Loaded.");
		
		Pet pet1 = Pet.builder().birthDate(LocalDate.now()).name("Lucky").petType(savedDogPetType).build();
		
		Owner owner1 = Owner.builder()
							.firstName("Michael")
							.lastName("Weston")
							.address("23 Flora Rd")
							.city("Miami")
							.telephone("3453423423")
							.build();
		owner1.getPets().add(pet1);
		Owner savedOwner1 = ownerService.save(owner1);
		System.out.println("========================== owner1: "+ owner1);

		Pet pet2 = Pet.builder().birthDate(LocalDate.now()).name("Meowmy").petType(savedCatPetType).build();
		
		Owner owner2 = Owner.builder()
				.firstName("Fiona")
				.lastName("Glenanne")
				.address("23 Chicken Rd")
				.city("Tokyo")
				.telephone("2322322334")
				.build();
		owner2.getPets().add(pet2);
		Owner savedOwner2 = ownerService.save(owner2);
		System.out.println("========================== owner2: "+ owner2);
		
		System.out.println("=================Owners Loaded.");

		Visit catVisit = Visit.builder()
							  .pet(savedOwner2.getPets().iterator().next())
							  .date(LocalDate.now())
							  .description("Sneezy Kitty")
							  .build();
		visitService.save(catVisit);
		
		System.out.println("================ Visit Loaded.");
		
		
		Specialty radiology = Specialty.builder().description("Radiology").build();
		Specialty savedRadiology = specialtyService.save(radiology);
		
		Specialty surgery = Specialty.builder().description("Surgery").build();
		Specialty savedSurgery = specialtyService.save(surgery);
		
		Specialty dentistry = Specialty.builder().description("Dentistry").build();
		Specialty savedDentistry = specialtyService.save(dentistry);
		
		Vet vet1 = Vet.builder()
					  .firstName("Sam")
					  .lastName("Axe")
					  .build();
		vet1.getSpecialties().add(savedRadiology);
		vetService.save(vet1);
		
		Vet vet2 = Vet.builder()
				  .firstName("Jessie")
				  .lastName("Porter")
				  .build();
		vet2.getSpecialties().add(savedSurgery);
		vetService.save(vet2);
		
		Vet vet3 = Vet.builder()
				  .firstName("Bob")
				  .lastName("Castle")
				  .build();
		vet3.getSpecialties().add(savedDentistry);
		vetService.save(vet3);
		
		System.out.println("======================== vet1: "+ vet1);
		System.out.println("======================== vet2: "+ vet2);
		System.out.println("======================== vet3: "+ vet3);
		System.out.println("=================Vets Loaded.");
	}

}
