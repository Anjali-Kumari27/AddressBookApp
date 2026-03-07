package com.addressbookapp;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.Contact;

import java.util.Scanner;

public class AddressBookMain {

	public static void start() {

		Scanner scanner = new Scanner(System.in);

		AddressBook addressBook = new AddressBook();

		System.out.println("Welcome to Address Book Program");

		System.out.println("\nEnter Contact Details");

		System.out.print("First Name: ");
		String firstName = scanner.nextLine();

		System.out.print("Last Name: ");
		String lastName = scanner.nextLine();

		System.out.print("Address: ");
		String address = scanner.nextLine();

		System.out.print("City: ");
		String city = scanner.nextLine();

		System.out.print("State: ");
		String state = scanner.nextLine();

		System.out.print("Zip: ");
		String zip = scanner.nextLine();

		System.out.print("Phone Number: ");
		String phone = scanner.nextLine();

		System.out.print("Email: ");
		String email = scanner.nextLine();

		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);

		addressBook.addContact(contact);

		System.out.println("\nContact added successfully!");
		addressBook.displayContact();

		System.out.println("\n=================================");
		System.out.println("          Delete Contact           ");
		System.out.println("=================================");

		System.out.print("Enter First Name to delete: ");
		String deleteName = scanner.nextLine();

		boolean deleted = addressBook.deleteContact(deleteName);

		if (deleted) {
			System.out.println("Contact deleted successfully.");
		} else {
			System.out.println("Contact not found.");
		}

		addressBook.displayContact();
	}
}