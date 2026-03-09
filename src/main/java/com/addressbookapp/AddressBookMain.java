package com.addressbookapp;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.AddressBookSystem;
import com.addressbookapp.model.Contact;
import com.addressbookapp.util.FileUtil;

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

		System.out.println("\n--- Sorting Menu ---");
		System.out.print("Enter Address Book Name to sort contacts: ");
		String sortBookName = scanner.nextLine();

		AddressBook sortBook = addressBookSystem.getAddressBook(sortBookName);

		if (sortBook == null) {
			System.out.println("Address Book not found.");
			return;
		}

		System.out.println("\nChoose sorting option:");
		System.out.println("1. Sort by Name");
		System.out.println("2. Sort by City");
		System.out.println("3. Sort by State");
		System.out.println("4. Sort by Zip");
		System.out.print("Enter your choice: ");

		int sortChoice = Integer.parseInt(scanner.nextLine());

		switch (sortChoice) {
		case 1:
			System.out.println("\n--- Sorted Contacts By Name ---");
			sortBook.displaySortedContactsByName();
			break;
		case 2:
			System.out.println("\n--- Sorted Contacts By City ---");
			sortBook.displaySortedContactsByCity();
			break;
		case 3:
			System.out.println("\n--- Sorted Contacts By State ---");
			sortBook.displaySortedContactsByState();
			break;
		case 4:
			System.out.println("\n--- Sorted Contacts By Zip ---");
			sortBook.displaySortedContactsByZip();
			break;
		default:
			System.out.println("Invalid choice.");
		}

		String textFileName = "addressbook.txt";

		System.out.println("\n--- UC13 File IO ---");
		System.out.println("\nWriting contacts to text file...");
		FileUtil.writeContactsToFile(sortBook.getContacts(), textFileName);

		System.out.println("\nReading contacts from text file...");
		List<Contact> contactsFromTextFile = FileUtil.readContactsFromFile(textFileName);

		System.out.println("\nContacts read from text file:");
		contactsFromTextFile.forEach(System.out::println);

		String csvFileName = "addressbook.csv";

		System.out.println("\n--- UC14 CSV File IO ---");
		System.out.println("\nWriting contacts to CSV file...");
		FileUtil.writeContactsToCSV(sortBook.getContacts(), csvFileName);

		System.out.println("\nReading contacts from CSV file...");
		List<Contact> contactsFromCSV = FileUtil.readContactsFromCSV(csvFileName);

		System.out.println("\nContacts read from CSV file:");
		contactsFromCSV.forEach(System.out::println);

		String jsonFileName = "addressbook.json";

		System.out.println("\n--- UC15 JSON File IO ---");
		System.out.println("\nWriting contacts to JSON file...");
		FileUtil.writeContactsToJSON(sortBook.getContacts(), jsonFileName);

		System.out.println("\nReading contacts from JSON file...");
		List<Contact> contactsFromJSON = FileUtil.readContactsFromJSON(jsonFileName);

		System.out.println("\nContacts read from JSON file:");
		contactsFromJSON.forEach(System.out::println);
	}
}