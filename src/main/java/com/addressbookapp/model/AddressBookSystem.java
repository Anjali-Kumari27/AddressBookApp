package com.addressbookapp.model;

import java.util.HashMap;
import java.util.Map;

public class AddressBookSystem {

	private Map<String, AddressBook> addressBookMap;

	public AddressBookSystem() {
		this.addressBookMap = new HashMap<>();
	}

	public boolean addAddressBook(String addressBookName) {
		if (addressBookMap.containsKey(addressBookName)) {
			return false;
		}

		addressBookMap.put(addressBookName, new AddressBook());
		return true;
	}

	public Map<String, AddressBook> getAddressBookMap() {
		return addressBookMap;
	}

	public AddressBook getAddressBook(String addressBookName) {
		return addressBookMap.get(addressBookName);
	}

	public void displayAddressBooks() {
		if (addressBookMap.isEmpty()) {
			System.out.println("No Address Books available in the system.");
			return;
		}

		System.out.println("\nAddress Books in System:");
		for (String name : addressBookMap.keySet()) {
			System.out.println(name);
		}
	}
}