package com.addressbookapp;

import com.addressbookapp.model.Contact;
import com.addressbookapp.service.AddressBookService;
import com.addressbookapp.service.AddressBookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressBookServiceTest {

	@Test
	void givenDatabase_WhenRetrieved_ShouldReturnAllContacts() {
		AddressBookService addressBookService = new AddressBookServiceImpl();
		Assertions.assertNotNull(addressBookService.getAllContactsFromDB());
		Assertions.assertTrue(addressBookService.getAllContactsFromDB().size() > 0);
	}

	@Test
	void givenContact_WhenUpdated_ShouldSyncWithDatabase() {
		AddressBookService addressBookService = new AddressBookServiceImpl();

		Contact existingContact = addressBookService.getContactByFirstName("Anjali");
		Assertions.assertNotNull(existingContact);

		String updatedPhoneNumber = "9999999999";
		boolean updated = addressBookService.updateContactPhoneNumber("Anjali", updatedPhoneNumber);

		Assertions.assertTrue(updated);

		Contact contactFromDB = addressBookService.getContactByFirstName("Anjali");
		Assertions.assertNotNull(contactFromDB);

		Contact expectedContact = new Contact(existingContact.getId(), existingContact.getFirstName(),
				existingContact.getLastName(), existingContact.getAddress(), existingContact.getCity(),
				existingContact.getState(), existingContact.getZip(), updatedPhoneNumber, existingContact.getEmail());

		Assertions.assertEquals(expectedContact, contactFromDB);
	}
}