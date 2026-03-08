package com.addressbookapp;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.AddressBookSystem;
import com.addressbookapp.model.Contact;

import java.util.Scanner;

public class AddressBookMain {

	public static void start() {

		Scanner scanner = new Scanner(System.in);
		AddressBookSystem addressBookSystem = new AddressBookSystem();

		System.out.println("Welcome to Address Book Program");

		System.out.print("\nEnter Address Book Name: ");
		String addressBookName = scanner.nextLine();

		boolean isAdded = addressBookSystem.addAddressBook(addressBookName);

		if (isAdded) {
			System.out.println("Address Book added successfully!");
		} else {
			System.out.println("Address Book already exists. Using existing Address Book.");
		}

		AddressBook addressBook = addressBookSystem.getAddressBook(addressBookName);

		String choice;

		do {
			System.out.println("\nEnter Contact Details:");

			System.out.print("Enter First Name: ");
			String firstName = scanner.nextLine();

			System.out.print("Enter Last Name: ");
			String lastName = scanner.nextLine();

			System.out.print("Enter Address: ");
			String address = scanner.nextLine();

			System.out.print("Enter City: ");
			String city = scanner.nextLine();

			System.out.print("Enter State: ");
			String state = scanner.nextLine();

			System.out.print("Enter Zip: ");
			String zip = scanner.nextLine();

			System.out.print("Enter Phone Number: ");
			String phoneNumber = scanner.nextLine();

			System.out.print("Enter Email: ");
			String email = scanner.nextLine();

			Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);

			boolean contactAdded = addressBook.addContact(contact);

			if (contactAdded) {
				System.out.println("Contact added successfully!");
			} else {
				System.out.println("Duplicate entry found. Contact not added.");
			}

			System.out.print("\nDo you want to add another contact? (yes/no): ");
			choice = scanner.nextLine();

		} while (choice.equalsIgnoreCase("yes"));

		System.out.println("\nContacts in Address Book: " + addressBookName);
		addressBook.displayContacts();
	}
}