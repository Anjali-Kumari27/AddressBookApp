package com.addressbookapp.util;

import com.addressbookapp.model.Contact;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static void writeContactsToFile(List<Contact> contacts, String fileName) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

			for (Contact contact : contacts) {
				writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getAddress() + ","
						+ contact.getCity() + "," + contact.getState() + "," + contact.getZip() + ","
						+ contact.getPhoneNumber() + "," + contact.getEmail());
				writer.newLine();
			}

			System.out.println("Contacts written to text file successfully.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Contact> readContactsFromFile(String fileName) {
		List<Contact> contacts = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;

			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");

				if (data.length == 8) {
					Contact contact = new Contact(data[0], data[1], data[2], data[3], data[4], data[5], data[6],
							data[7]);
					contacts.add(contact);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return contacts;
	}

	public static void writeContactsToCSV(List<Contact> contacts, String fileName) {
		try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {

			String[] header = { "FirstName", "LastName", "Address", "City", "State", "Zip", "PhoneNumber", "Email" };
			writer.writeNext(header);

			for (Contact contact : contacts) {
				String[] data = { contact.getFirstName(), contact.getLastName(), contact.getAddress(),
						contact.getCity(), contact.getState(), contact.getZip(), contact.getPhoneNumber(),
						contact.getEmail() };
				writer.writeNext(data);
			}

			System.out.println("Contacts written to CSV file successfully.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Contact> readContactsFromCSV(String fileName) {
		List<Contact> contacts = new ArrayList<>();

		try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
			List<String[]> records = reader.readAll();

			for (int i = 1; i < records.size(); i++) {
				String[] data = records.get(i);

				if (data.length == 8) {
					Contact contact = new Contact(data[0], data[1], data[2], data[3], data[4], data[5], data[6],
							data[7]);
					contacts.add(contact);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return contacts;
	}
}