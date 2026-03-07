package com.addressbookapp.model;

public class AddressBook {

	private Contact contact;

	public void addContact(Contact contact) {
		this.contact = contact;
	}

	public Contact getContact() {
		return contact;
	}

	public void displayContact() {
		if (contact != null) {
			System.out.println(contact);
		} else {
			System.out.println("No contact found in Address Book.");
		}
	}
}