package com.addressbookapp;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.AddressBookSystem;
import com.addressbookapp.model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookSystemTest {

	@Test
	void givenMultipleAddressBooks_WhenSearchByCity_ShouldReturnMatchingContacts() {
		AddressBookSystem system = new AddressBookSystem();

		system.addAddressBook("Friends");
		system.addAddressBook("Family");

		AddressBook friends = system.getAddressBook("Friends");
		AddressBook family = system.getAddressBook("Family");

		friends.addContact(new Contact("Anjali", "Singh", "A1", "Bhopal", "MP", "462001", "12345", "anjali@gmail.com"));
		family.addContact(new Contact("Arpita", "Sharma", "A2", "Bhopal", "MP", "462002", "67890", "arpita@gmail.com"));
		family.addContact(new Contact("Riya", "Verma", "A3", "Indore", "MP", "452001", "99999", "riya@gmail.com"));

		List<Contact> result = system.searchPersonByCity("Bhopal");

		Assertions.assertEquals(2, result.size());
	}

	@Test
	void givenMultipleAddressBooks_WhenSearchByState_ShouldReturnMatchingContacts() {
		AddressBookSystem system = new AddressBookSystem();

		system.addAddressBook("Friends");
		system.addAddressBook("Office");

		AddressBook friends = system.getAddressBook("Friends");
		AddressBook office = system.getAddressBook("Office");

		friends.addContact(new Contact("Anjali", "Singh", "A1", "Bhopal", "MP", "462001", "12345", "anjali@gmail.com"));
		office.addContact(new Contact("Rohit", "Kumar", "A2", "Lucknow", "UP", "226001", "67890", "rohit@gmail.com"));
		office.addContact(new Contact("Pooja", "Sharma", "A3", "Kanpur", "UP", "208001", "77777", "pooja@gmail.com"));

		List<Contact> result = system.searchPersonByState("UP");

		Assertions.assertEquals(2, result.size());
	}
}