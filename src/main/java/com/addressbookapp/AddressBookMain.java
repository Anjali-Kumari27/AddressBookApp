package com.addressbookapp;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.AddressBookSystem;
import com.addressbookapp.model.Contact;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {

	public static void start() {

		Scanner scanner = new Scanner(System.in);
		AddressBookSystem addressBookSystem = new AddressBookSystem();

		System.out.println("Welcome to Address Book Program");

		String mainChoice;

		do {
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

				System.out.print("\nDo you want to add another contact in this address book? (yes/no): ");
				choice = scanner.nextLine();

			} while (choice.equalsIgnoreCase("yes"));

			System.out.print("\nDo you want to add another Address Book? (yes/no): ");
			mainChoice = scanner.nextLine();

		} while (mainChoice.equalsIgnoreCase("yes"));

		System.out.println("\n--- Search Menu ---");

		System.out.print("Enter city to search: ");
		String cityToSearch = scanner.nextLine();

		List<Contact> cityResults = addressBookSystem.searchPersonByCity(cityToSearch);

		if (cityResults.isEmpty()) {
			System.out.println("No person found in city: " + cityToSearch);
		} else {
			System.out.println("\nPersons found in city: " + cityToSearch);
			cityResults.forEach(System.out::println);
		}

		System.out.print("\nEnter state to search: ");
		String stateToSearch = scanner.nextLine();

		List<Contact> stateResults = addressBookSystem.searchPersonByState(stateToSearch);

		if (stateResults.isEmpty()) {
			System.out.println("No person found in state: " + stateToSearch);
		} else {
			System.out.println("\nPersons found in state: " + stateToSearch);
			stateResults.forEach(System.out::println);
		}

		System.out.println("\n--- View Persons By City ---");
		Map<String, List<Contact>> cityMap = addressBookSystem.viewPersonsByCity();

		cityMap.forEach((city, contacts) -> {
			System.out.println("\nCity: " + city);
			contacts.forEach(System.out::println);
		});

		System.out.println("\n--- View Persons By State ---");
		Map<String, List<Contact>> stateMap = addressBookSystem.viewPersonsByState();

		stateMap.forEach((stateName, contacts) -> {
			System.out.println("\nState: " + stateName);
			contacts.forEach(System.out::println);
		});

		System.out.println("\n--- Count By City ---");
		Map<String, Long> cityCountMap = addressBookSystem.countPersonsByCity();

		cityCountMap.forEach((city, count) -> System.out.println("City: " + city + " -> Count: " + count));

		System.out.println("\n--- Count By State ---");
		Map<String, Long> stateCountMap = addressBookSystem.countPersonsByState();

		stateCountMap.forEach((stateName, count) -> System.out.println("State: " + stateName + " -> Count: " + count));

		System.out.println("\n--- Sorted Contacts By Name (for each Address Book) ---");
		System.out.print("Enter Address Book Name to sort contacts: ");
		String sortBookName = scanner.nextLine();

		AddressBook sortBook = addressBookSystem.getAddressBook(sortBookName);

		if (sortBook == null) {
			System.out.println("Address Book not found.");
		} else {
			sortBook.displaySortedContactsByName();
		}
	}
}