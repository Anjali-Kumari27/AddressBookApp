package com.addressbookapp;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {

	@Test
	public void givenContact_whenDeletedByName_shouldRemoveContact() {

		AddressBook addressBook = new AddressBook();

		Contact contact = new Contact(
				"Anjali",
				"Singh",
				"123 MG Road",
				"Bhopal",
				"MP",
				"462001",
				"9876543210",
				"anjali@example.com"
		);

		addressBook.addContact(contact);

		boolean result = addressBook.deleteContact("Anjali");

		assertTrue(result);
		assertNull(addressBook.getContact());
	}

	@Test
	public void givenWrongName_whenDeleted_shouldReturnFalse() {

		AddressBook addressBook = new AddressBook();

		Contact contact = new Contact(
				"Anjali",
				"Singh",
				"123 MG Road",
				"Bhopal",
				"MP",
				"462001",
				"9876543210",
				"anjali@example.com"
		);

		addressBook.addContact(contact);

		boolean result = addressBook.deleteContact("Rahul");

		assertFalse(result);
		assertNotNull(addressBook.getContact());
	}
}