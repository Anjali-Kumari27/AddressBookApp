package com.addressbookapp;

import com.addressbookapp.model.Contact;
import com.addressbookapp.service.AddressBookService;
import com.addressbookapp.service.AddressBookServiceImpl;

import java.util.List;
import java.util.Scanner;

public class AddressBookMain {

	public static void start() {
		Scanner scanner = new Scanner(System.in);
		AddressBookService addressBookService = new AddressBookServiceImpl();

		System.out.println("Welcome to Address Book Program - UC17");

		List<Contact> contacts = addressBookService.getAllContactsFromDB();

		System.out.println("\nContacts retrieved from database:");
		contacts.forEach(System.out::println);

		System.out.print("\nEnter first name of contact to update phone number: ");
		String firstName = scanner.nextLine();

		System.out.print("Enter new phone number: ");
		String newPhoneNumber = scanner.nextLine();

		boolean updated = addressBookService.updateContactPhoneNumber(firstName, newPhoneNumber);

		if (updated) {
			System.out.println("Contact updated successfully in DB.");

			Contact updatedContact = addressBookService.getContactByFirstName(firstName);
			System.out.println("\nUpdated contact from DB:");
			System.out.println(updatedContact);
		} else {
			System.out.println("No contact found to update.");
		}
	}
}