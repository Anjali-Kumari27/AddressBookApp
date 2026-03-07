package com.addressbookapp;

import com.addressbookapp.model.AddressBookSystem;

import java.util.Scanner;

public class AddressBookMain {

	public static void start() {

		Scanner scanner = new Scanner(System.in);
		AddressBookSystem addressBookSystem = new AddressBookSystem();

		System.out.println("Welcome to Address Book Program");

		String choice;

		do {
			System.out.print("\nEnter Address Book Name: ");
			String addressBookName = scanner.nextLine();

			boolean isAdded = addressBookSystem.addAddressBook(addressBookName);

			if (isAdded) {
				System.out.println("Address Book added successfully!");
			} else {
				System.out.println("Address Book with this name already exists.");
			}

			System.out.print("Do you want to add another Address Book? (yes/no): ");
			choice = scanner.nextLine();

		} while (choice.equalsIgnoreCase("yes"));

		addressBookSystem.displayAddressBooks();
	}
}