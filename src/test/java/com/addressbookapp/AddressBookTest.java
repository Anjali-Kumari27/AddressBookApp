package com.addressbookapp;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {

	@Test
	public void givenContact_whenAddedToAddressBook_shouldReturnSameContact() {

		AddressBook addressBook = new AddressBook();

		Contact contact = new Contact("Anjali", "Singh", "123 MG Road", "Bhopal", "Madhya Pradesh", "462001",
				"9876543210", "anjali@example.com");

		addressBook.addContact(contact);

		Contact storedContact = addressBook.getContact();

		assertNotNull(storedContact);
		assertEquals("Anjali", storedContact.getFirstName());
		assertEquals("Singh", storedContact.getLastName());
		assertEquals("Bhopal", storedContact.getCity());
	}
}