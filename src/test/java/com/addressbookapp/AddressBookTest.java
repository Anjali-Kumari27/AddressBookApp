package com.addressbookapp;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookTest {

	@Test
	void givenNewContact_WhenAdded_ShouldReturnTrue() {
		AddressBook addressBook = new AddressBook();

		Contact contact = new Contact("Anjali", "Singh", "GKP UP", "Gorakhpur", "UP", "273001", "9876543210",
				"anjali@example.com");

		boolean result = addressBook.addContact(contact);

		Assertions.assertTrue(result);
		Assertions.assertEquals(1, addressBook.getContacts().size());
	}

	@Test
	void givenDuplicateContact_WhenAdded_ShouldReturnFalse() {
		AddressBook addressBook = new AddressBook();

		Contact contact1 = new Contact("Anjali", "Singh", "GKP UP", "Gorakhpur", "UP", "273001", "9876543210",
				"anjali@example.com");

		Contact contact2 = new Contact("Anjali", "Singh", "Some Other Address", "Lucknow", "UP", "226001", "9999999999",
				"newmail@example.com");

		addressBook.addContact(contact1);
		boolean result = addressBook.addContact(contact2);

		Assertions.assertFalse(result);
		Assertions.assertEquals(1, addressBook.getContacts().size());
	}

	@Test
	void givenMultipleContacts_WhenSortedByName_ShouldReturnAlphabeticalOrder() {
		AddressBook addressBook = new AddressBook();

		addressBook.addContact(new Contact("Madhu", "Singh", "A", "Kolkata", "WB", "45", "1234", "madhu@mail.com"));
		addressBook.addContact(new Contact("Anjali", "Singh", "B", "Bhopal", "MP", "34", "2345", "anjali@mail.com"));
		addressBook.addContact(new Contact("Arpita", "Sharma", "C", "Noida", "UP", "22", "3456", "arpita@mail.com"));

		List<Contact> sortedContacts = addressBook.sortContactsByName();

		Assertions.assertEquals("Anjali", sortedContacts.get(0).getFirstName());
		Assertions.assertEquals("Arpita", sortedContacts.get(1).getFirstName());
		Assertions.assertEquals("Madhu", sortedContacts.get(2).getFirstName());
	}

	@Test
	void givenMultipleContacts_WhenSortedByCity_ShouldReturnCorrectOrder() {
		AddressBook addressBook = new AddressBook();

		addressBook.addContact(new Contact("Madhu", "Singh", "A", "Kolkata", "WB", "45", "1234", "madhu@mail.com"));
		addressBook.addContact(new Contact("Anjali", "Singh", "B", "Bhopal", "MP", "34", "2345", "anjali@mail.com"));
		addressBook.addContact(new Contact("Arpita", "Sharma", "C", "Noida", "UP", "22", "3456", "arpita@mail.com"));

		List<Contact> sortedContacts = addressBook.sortContactsByCity();

		Assertions.assertEquals("Bhopal", sortedContacts.get(0).getCity());
		Assertions.assertEquals("Kolkata", sortedContacts.get(1).getCity());
		Assertions.assertEquals("Noida", sortedContacts.get(2).getCity());
	}

	@Test
	void givenMultipleContacts_WhenSortedByState_ShouldReturnCorrectOrder() {
		AddressBook addressBook = new AddressBook();

		addressBook.addContact(new Contact("Madhu", "Singh", "A", "Kolkata", "WB", "45", "1234", "madhu@mail.com"));
		addressBook.addContact(new Contact("Anjali", "Singh", "B", "Bhopal", "MP", "34", "2345", "anjali@mail.com"));
		addressBook.addContact(new Contact("Arpita", "Sharma", "C", "Noida", "UP", "22", "3456", "arpita@mail.com"));

		List<Contact> sortedContacts = addressBook.sortContactsByState();

		Assertions.assertEquals("MP", sortedContacts.get(0).getState());
		Assertions.assertEquals("UP", sortedContacts.get(1).getState());
		Assertions.assertEquals("WB", sortedContacts.get(2).getState());
	}

	@Test
	void givenMultipleContacts_WhenSortedByZip_ShouldReturnCorrectOrder() {
		AddressBook addressBook = new AddressBook();

		addressBook.addContact(new Contact("Madhu", "Singh", "A", "Kolkata", "WB", "45", "1234", "madhu@mail.com"));
		addressBook.addContact(new Contact("Anjali", "Singh", "B", "Bhopal", "MP", "34", "2345", "anjali@mail.com"));
		addressBook.addContact(new Contact("Arpita", "Sharma", "C", "Noida", "UP", "22", "3456", "arpita@mail.com"));

		List<Contact> sortedContacts = addressBook.sortContactsByZip();

		Assertions.assertEquals("22", sortedContacts.get(0).getZip());
		Assertions.assertEquals("34", sortedContacts.get(1).getZip());
		Assertions.assertEquals("45", sortedContacts.get(2).getZip());
	}
}