package com.addressbookapp.model;

import java.util.Scanner;

public class AddressBook {

	private Contact contact;

	public void addContact(Contact contact) {
		this.contact = contact;
	}

	public Contact getContact() {
		return contact;
	}

	public void displayContact() {
		if (contact != null) {
			System.out.println(contact);
		} else {
			System.out.println("No contact available.");
		}
	}

	public void editContact(String firstName) {

		if (contact != null && contact.getFirstName().equals(firstName)) {

			Scanner scanner = new Scanner(System.in);

			System.out.println("\nEditing Contact: " + firstName);

			System.out.print("Enter new City: ");
			String city = scanner.nextLine();
			contact.setCity(city);

			System.out.print("Enter new State: ");
			String state = scanner.nextLine();
			contact.setState(state);

			System.out.print("Enter new Phone Number: ");
			String phone = scanner.nextLine();
			contact.setPhoneNumber(phone);

			System.out.print("Enter new Email: ");
			String email = scanner.nextLine();
			contact.setEmail(email);

			System.out.println("Contact updated successfully!");

		} else {
			System.out.println("Contact not found.");
		}
	}
}