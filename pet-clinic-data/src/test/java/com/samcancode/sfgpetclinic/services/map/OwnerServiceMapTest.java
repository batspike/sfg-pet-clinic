package com.samcancode.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import com.samcancode.sfgpetclinic.model.Owner;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class OwnerServiceMapTest {
	private OwnerServiceMap ownerService;
	
	private Owner savedOwner1;
	private Owner savedOwner2;
	
	@BeforeAll
	void setup() {
		ownerService = new OwnerServiceMap();
	}

	@Test
	@Order(3)
	void testFindByLastName() {
		assertNotNull( ownerService.findByLastName(savedOwner1.getLastName()) );
	}

	@Test
	@Order(2)
	void testFindAll() {
		Set<Owner> owners = ownerService.findAll();
		assertEquals(2, owners.size());
	}

	@Test
	@Order(4)
	void testFindById() {
		assertNotNull(ownerService.findById(savedOwner1.getId()));
	}

	@Test
	@Order(1)
	void testSave() {
		Owner owner1 = Owner.builder()
							.address("123 Good Rd")
							.city("New York")
							.firstName("Pika")
							.lastName("Poncho")
							.telephone("4565878")
							.build();
		savedOwner1 = ownerService.save(owner1);
		assertNotNull(savedOwner1);

		Owner owner2 = Owner.builder()
				.address("123 Good Rd")
				.city("Miami")
				.firstName("Rick")
				.lastName("Martin")
				.telephone("4565878")
				.build();
		savedOwner2 = ownerService.save(owner2);
		assertNotNull(savedOwner2);
		
	}

	@Test
	@Order(5)
	void testDeleteById() {
		ownerService.deleteById(savedOwner1.getId());
		Set<Owner> owners = ownerService.findAll();
		assertEquals(1, owners.size());
	}

	@Test
	void testDelete() {
		ownerService.delete(savedOwner2);
		Set<Owner> owners = ownerService.findAll();
		assertEquals(0, owners.size());	
	}

}
