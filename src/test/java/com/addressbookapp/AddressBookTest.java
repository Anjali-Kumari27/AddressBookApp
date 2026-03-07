package com.addressbookapp;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {

	@Test
	public void givenMultipleContacts_whenAdded_shouldStoreAllContacts() {

		AddressBook addressBook = new AddressBook();

		Contact contact1 = new Contact(
				"Anjali",
				"Singh",
				"123 MG Road",
				"Bhopal",
				"Madhya Pradesh",
				"462001",
				"9876543210",
				"anjali@example.com"
		);

		Contact contact2 = new Contact(
				"Rahul",
				"Verma",
				"45 Lake View",
				"Indore",
				"Madhya Pradesh",
				"452001",
				"9999999999",
				"rahul@example.com"
		);

		addressBook.addContact(contact1);
		addressBook.addContact(contact2);

		assertEquals(2, addressBook.getContactList().size());
	}
}