package com.addressbookapp.service;

import com.addressbookapp.model.Contact;
import com.addressbookapp.repository.AddressBookDBService;

import java.util.List;

public class AddressBookServiceImpl implements AddressBookService {

	private final AddressBookDBService addressBookDBService;

	public AddressBookServiceImpl() {
		this.addressBookDBService = new AddressBookDBService();
	}

	@Override
	public List<Contact> getAllContactsFromDB() {
		return addressBookDBService.getAllContacts();
	}

	@Override
	public boolean updateContactPhoneNumber(String firstName, String newPhoneNumber) {
		int rowsUpdated = addressBookDBService.updateContactPhoneNumberByFirstName(firstName, newPhoneNumber);
		return rowsUpdated > 0;
	}

	@Override
	public Contact getContactByFirstName(String firstName) {
		return addressBookDBService.getContactByFirstName(firstName);
	}
}