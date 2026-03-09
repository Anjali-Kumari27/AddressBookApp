package com.addressbookapp;

import com.addressbookapp.model.Contact;
import com.addressbookapp.service.AddressBookService;
import com.addressbookapp.service.AddressBookServiceImpl;

import java.util.List;

public class AddressBookMain {

	public static void start() {
		System.out.println("Welcome to Address Book Program - UC16");

		AddressBookService addressBookService = new AddressBookServiceImpl();
		List<Contact> contacts = addressBookService.getAllContactsFromDB();

		if (contacts.isEmpty()) {
			System.out.println("No contacts found in database.");
		} else {
			System.out.println("\nContacts retrieved from database:");
			contacts.forEach(System.out::println);
		}
	}
}