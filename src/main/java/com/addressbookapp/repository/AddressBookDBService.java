package com.addressbookapp.repository;

import com.addressbookapp.model.Contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {

	private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/addressbook_service";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "anjali123";

	public List<Contact> getAllContacts() {
		List<Contact> contacts = new ArrayList<>();

		String query = "SELECT id, first_name, last_name, address, city, state, zip, phone_number, email FROM address_book";

		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

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

	public int updateContactPhoneNumberByFirstName(String firstName, String newPhoneNumber) {
		String query = "UPDATE address_book SET phone_number = ? WHERE first_name = ?";

		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, newPhoneNumber);
			preparedStatement.setString(2, firstName);

			return preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public Contact getContactByFirstName(String firstName) {
		String query = "SELECT id, first_name, last_name, address, city, state, zip, phone_number, email "
				+ "FROM address_book WHERE first_name = ? LIMIT 1";

		try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, firstName);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return new Contact(resultSet.getInt("id"), resultSet.getString("first_name"),
							resultSet.getString("last_name"), resultSet.getString("address"),
							resultSet.getString("city"), resultSet.getString("state"), resultSet.getString("zip"),
							resultSet.getString("phone_number"), resultSet.getString("email"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}