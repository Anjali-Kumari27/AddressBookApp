package com.addressbookapp;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.Contact;

import java.util.Scanner;

public class AddressBookMain {

	public static void start() {

		Scanner scanner = new Scanner(System.in);
		AddressBook addressBook = new AddressBook();

		System.out.println("Welcome to Address Book Program");

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
			addressBook.addContact(contact);

			System.out.print("\nDo you want to add another contact? (yes/no): ");
			choice = scanner.nextLine();

		} while (choice.equalsIgnoreCase("yes"));

		System.out.println("\nAll Contacts in Address Book:");
		addressBook.displayContacts();
	}
}