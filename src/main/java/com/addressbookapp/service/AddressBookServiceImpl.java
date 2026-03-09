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
}