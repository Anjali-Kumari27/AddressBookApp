package com.addressbookapp;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.AddressBookSystem;
import com.addressbookapp.model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class AddressBookSystemTest {

	@Test
	void givenMultipleContacts_WhenCountedByCity_ShouldReturnCorrectCounts() {
		AddressBookSystem system = new AddressBookSystem();

		system.addAddressBook("Friends");
		system.addAddressBook("Family");

		AddressBook friends = system.getAddressBook("Friends");
		AddressBook family = system.getAddressBook("Family");

		friends.addContact(new Contact("Anjali", "Singh", "A1", "Bhopal", "MP", "462001", "12345", "anjali@gmail.com"));
		friends.addContact(
				new Contact("Arpita", "Sharma", "A2", "Bhopal", "MP", "462002", "67890", "arpita@gmail.com"));
		family.addContact(new Contact("Riya", "Verma", "A3", "Noida", "UP", "201301", "99999", "riya@gmail.com"));

		Map<String, Long> cityCountMap = system.countPersonsByCity();

		Assertions.assertEquals(2L, cityCountMap.get("bhopal"));
		Assertions.assertEquals(1L, cityCountMap.get("noida"));
	}

	@Test
	void givenMultipleContacts_WhenCountedByState_ShouldReturnCorrectCounts() {
		AddressBookSystem system = new AddressBookSystem();

		system.addAddressBook("Friends");
		system.addAddressBook("Office");

		AddressBook friends = system.getAddressBook("Friends");
		AddressBook office = system.getAddressBook("Office");

		friends.addContact(new Contact("Anjali", "Singh", "A1", "Bhopal", "MP", "462001", "12345", "anjali@gmail.com"));
		office.addContact(new Contact("Rohit", "Kumar", "A2", "Lucknow", "UP", "226001", "67890", "rohit@gmail.com"));
		office.addContact(new Contact("Pooja", "Sharma", "A3", "Kanpur", "UP", "208001", "77777", "pooja@gmail.com"));

		Map<String, Long> stateCountMap = system.countPersonsByState();

		Assertions.assertEquals(1L, stateCountMap.get("mp"));
		Assertions.assertEquals(2L, stateCountMap.get("up"));
	}
}