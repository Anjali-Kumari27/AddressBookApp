package com.addressbookapp;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.AddressBookSystem;
import com.addressbookapp.model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class AddressBookSystemTest {

	@Test
	void givenMultipleContacts_WhenViewedByCity_ShouldGroupCorrectly() {
		AddressBookSystem system = new AddressBookSystem();

		system.addAddressBook("Friends");
		system.addAddressBook("Family");

		AddressBook friends = system.getAddressBook("Friends");
		AddressBook family = system.getAddressBook("Family");

		friends.addContact(new Contact("Anjali", "Singh", "A1", "Bhopal", "MP", "462001", "12345", "anjali@gmail.com"));
		friends.addContact(
				new Contact("Arpita", "Sharma", "A2", "Bhopal", "MP", "462002", "67890", "arpita@gmail.com"));
		family.addContact(new Contact("Riya", "Verma", "A3", "Noida", "UP", "201301", "99999", "riya@gmail.com"));

		Map<String, List<Contact>> cityMap = system.viewPersonsByCity();

		Assertions.assertEquals(2, cityMap.get("bhopal").size());
		Assertions.assertEquals(1, cityMap.get("noida").size());
	}

	@Test
	void givenMultipleContacts_WhenViewedByState_ShouldGroupCorrectly() {
		AddressBookSystem system = new AddressBookSystem();

		system.addAddressBook("Friends");
		system.addAddressBook("Office");

		AddressBook friends = system.getAddressBook("Friends");
		AddressBook office = system.getAddressBook("Office");

		friends.addContact(new Contact("Anjali", "Singh", "A1", "Bhopal", "MP", "462001", "12345", "anjali@gmail.com"));
		office.addContact(new Contact("Rohit", "Kumar", "A2", "Lucknow", "UP", "226001", "67890", "rohit@gmail.com"));
		office.addContact(new Contact("Pooja", "Sharma", "A3", "Kanpur", "UP", "208001", "77777", "pooja@gmail.com"));

		Map<String, List<Contact>> stateMap = system.viewPersonsByState();

		Assertions.assertEquals(1, stateMap.get("mp").size());
		Assertions.assertEquals(2, stateMap.get("up").size());
	}
}