package com.samcancode.sfgpetclinic.services.springjpadb;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import com.samcancode.sfgpetclinic.model.Owner;
import com.samcancode.sfgpetclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(OrderAnnotation.class)
class OwnerServiceJpaDbTest {
	@Mock
	private OwnerRepository ownerRepo;
	
	@InjectMocks
	private OwnerServiceJpaDb ownerService;
	
	@Test
	@Order(3)
	void testFindByLastName() {
		//Given
		Owner owner1 = Owner.builder().id(1L).lastName("abc").build();
		
		//When
		when(ownerRepo.findByLastName(any())).thenReturn(owner1);
		
		//Then
		Owner abc = ownerService.findByLastName("abc");
		assertEquals("abc", abc.getLastName());
		assertNotNull(abc);
		
	}

	@Disabled
	@Test
	@Order(2)
	void testFindAll() {
		//Given
		Set<Owner> owners = new HashSet<>();
		Owner owner1 = Owner.builder().id(1L).build();
		Owner owner2 = Owner.builder().id(2L).build();
		owners.add(owner1);
		owners.add(owner2);
		
		//When
		when(ownerRepo.findAll()).thenReturn(owners);
		
		//Then
		Set<Owner> result = ownerService.findAll();
		assertEquals(2, result.size());
	}

	@Test
	@Order(4)
	void testFindById() {
		//Given
		Optional<Owner> saveOwnerOpt = Optional.of(Owner.builder().id(1L).build());
		
		//When
		when(ownerRepo.findById(anyLong())).thenReturn(saveOwnerOpt);
		
		//Then
		assertNotNull(ownerService.findById(1L));
	}

	@Test
	@Order(1)
	void testSave() {
		//Given
		Owner owner1 = Owner.builder()
							.id(1L)
							.address("123 Good Rd")
							.city("New York")
							.firstName("Pika")
							.lastName("Poncho")
							.telephone("4565878")
							.build();
		
		//When
		when(ownerRepo.save(any())).thenReturn(owner1);
		
		//Then
		assertNotNull(ownerService.save(owner1));
		
		//================================================

		//Given
		Owner owner2 = Owner.builder()
				.id(2L)
				.address("123 Good Rd")
				.city("Miami")
				.firstName("Rick")
				.lastName("Martin")
				.telephone("4565878")
				.build();
		
		//When
		when(ownerRepo.save(any())).thenReturn(owner2);
		
		//Then
		assertNotNull(ownerService.save(owner2));
	}

	@Test
	@Order(5)
	void testDeleteById() {
		//Given
		Owner owner = Owner.builder().id(1L).build();
		
		//When
		ownerService.deleteById(owner.getId());
		
		//Then
		verify(ownerRepo).deleteById(anyLong());
	}

	@Test
	@Order(6)
	void testDelete() {
		//Given
		Owner owner = Owner.builder().id(1L).build();
		
		//When
		ownerService.delete(owner);
		
		//Then
		verify(ownerRepo).delete(any(Owner.class));
	}

}
