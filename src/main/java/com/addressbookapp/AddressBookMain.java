package com.addressbookapp;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.Contact;

import java.util.Scanner;

public class AddressBookMain {

	public static void start() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Address Book Program");

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
		String phone = scanner.nextLine();

		System.out.print("Enter Email: ");
		String email = scanner.nextLine();

		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);

		AddressBook addressBook = new AddressBook();

		addressBook.addContact(contact);

		System.out.println("\nContact added successfully!");
		addressBook.displayContact();

		System.out.println("\n----------------------");
		System.out.println("      Edit Contact    ");
		System.out.println("----------------------");

		System.out.print("Enter First Name to edit: ");
		String editName = scanner.nextLine();

		addressBook.editContact(editName);

		System.out.println("\nUpdated Contact:");
		addressBook.displayContact();
	}
}