package com.addressbookapp;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.Contact;

import java.util.Scanner;

public class AddressBookMain {

	public static void start() {

		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to Address Book Program");
		System.out.println("\nEnter Contact Details:");

		System.out.print("Enter First Name: ");
		String firstName = input.nextLine();

		System.out.print("Enter Last Name: ");
		String lastName = input.nextLine();

		System.out.print("Enter Address: ");
		String address = input.nextLine();

		System.out.print("Enter City: ");
		String city = input.nextLine();

		System.out.print("Enter State: ");
		String state = input.nextLine();

		System.out.print("Enter Zip: ");
		String zip = input.nextLine();

		System.out.print("Enter Phone Number: ");
		String phoneNumber = input.nextLine();

		System.out.print("Enter Email: ");
		String email = input.nextLine();

		Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);

		AddressBook addressBook = new AddressBook();
		addressBook.addContact(contact);

		System.out.println("\nContact added successfully to Address Book!");
		addressBook.displayContact();
	}
}