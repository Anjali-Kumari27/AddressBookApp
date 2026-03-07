package com.addressbookapp;

import com.addressbookapp.model.AddressBookSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookSystemTest {

	@Test
	public void givenNewAddressBookName_whenAdded_shouldStoreInMap() {

		AddressBookSystem system = new AddressBookSystem();

		boolean result = system.addAddressBook("HomeBook");

		assertTrue(result);
		assertEquals(1, system.getAddressBookMap().size());
		assertNotNull(system.getAddressBook("HomeBook"));
	}

	@Test
	public void givenDuplicateAddressBookName_whenAdded_shouldReturnFalse() {

		AddressBookSystem system = new AddressBookSystem();

		system.addAddressBook("HomeBook");
		boolean result = system.addAddressBook("HomeBook");

		assertFalse(result);
		assertEquals(1, system.getAddressBookMap().size());
	}
}