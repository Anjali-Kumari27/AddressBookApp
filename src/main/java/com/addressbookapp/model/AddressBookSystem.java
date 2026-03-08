package com.addressbookapp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBookSystem {

	private Map<String, AddressBook> addressBooks;

	public AddressBookSystem() {
		this.addressBooks = new HashMap<>();
	}

	public boolean addAddressBook(String addressBookName) {
		if (addressBooks.containsKey(addressBookName)) {
			return false;
		}

		addressBooks.put(addressBookName, new AddressBook());
		return true;
	}

	public AddressBook getAddressBook(String addressBookName) {
		return addressBooks.get(addressBookName);
	}

	public List<Contact> searchPersonByCity(String city) {
		return addressBooks.values().stream().flatMap(addressBook -> addressBook.getContacts().stream())
				.filter(contact -> contact.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
	}

	public List<Contact> searchPersonByState(String state) {
		return addressBooks.values().stream().flatMap(addressBook -> addressBook.getContacts().stream())
				.filter(contact -> contact.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
	}

	public Map<String, List<Contact>> viewPersonsByCity() {
		return addressBooks.values().stream().flatMap(addressBook -> addressBook.getContacts().stream())
				.collect(Collectors.groupingBy(contact -> contact.getCity().toLowerCase()));
	}

	public Map<String, List<Contact>> viewPersonsByState() {
		return addressBooks.values().stream().flatMap(addressBook -> addressBook.getContacts().stream())
				.collect(Collectors.groupingBy(contact -> contact.getState().toLowerCase()));
	}
}