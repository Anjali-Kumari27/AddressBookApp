package com.addressbookapp.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

	private List<Contact> contacts;

	public AddressBook() {
		this.contacts = new ArrayList<>();
	}

	public boolean addContact(Contact newContact) {
		boolean isDuplicate = contacts.stream().anyMatch(existingContact -> existingContact.equals(newContact));

		if (isDuplicate) {
			return false;
		}

		contacts.add(newContact);
		return true;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void displayContacts() {
		if (contacts.isEmpty()) {
			System.out.println("No contacts found.");
			return;
		}

		contacts.forEach(System.out::println);
	}

	public List<Contact> sortContactsByName() {
		return contacts.stream()
				.sorted(Comparator.comparing(Contact::getFirstName, String.CASE_INSENSITIVE_ORDER)
						.thenComparing(Contact::getLastName, String.CASE_INSENSITIVE_ORDER))
				.collect(Collectors.toList());
	}

	public void displaySortedContactsByName() {
		List<Contact> sortedContacts = sortContactsByName();

		if (sortedContacts.isEmpty()) {
			System.out.println("No contacts available for sorting.");
			return;
		}

		sortedContacts.forEach(System.out::println);
	}
}