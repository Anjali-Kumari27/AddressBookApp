package com.addressbookapp;

import com.addressbookapp.model.Contact;
import com.addressbookapp.service.AddressBookService;
import com.addressbookapp.service.AddressBookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookServiceTest {

	@Test
	void givenDatabase_WhenRetrieved_ShouldReturnAllContacts() {
		AddressBookService addressBookService = new AddressBookServiceImpl();

		List<Contact> contacts = addressBookService.getAllContactsFromDB();

		Assertions.assertNotNull(contacts);
		Assertions.assertTrue(contacts.size() > 0);
	}
}