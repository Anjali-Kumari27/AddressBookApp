package com.addressbookapp.repository;

import com.addressbookapp.model.Contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {

	static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/addressbook_service";
	static final String USERNAME = "root";
	static final String PASSWORD = "anjali123";

	public List<Contact> getAllContacts() {

		List<Contact> contacts = new ArrayList<>();

		String query = "SELECT id, first_name, last_name, address, city, state, zip, phone_number, email FROM address_book";

		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query)) {

			while (resultSet.next()) {

				Contact contact = new Contact(resultSet.getInt("id"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getString("address"), resultSet.getString("city"),
						resultSet.getString("state"), resultSet.getString("zip"), resultSet.getString("phone_number"),
						resultSet.getString("email"));

				contacts.add(contact);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return contacts;
	}
}