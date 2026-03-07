package com.addressbookapp.model;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	private List<Contact> contactList;

	public AddressBook() {
		this.contactList = new ArrayList<>();
	}

	public void addContact(Contact contact) {
		contactList.add(contact);
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void displayContacts() {
		if (contactList.isEmpty()) {
			System.out.println("No contacts available in Address Book.");
			return;
		}

		for (Contact contact : contactList) {
			System.out.println(contact);
		}
	}
}