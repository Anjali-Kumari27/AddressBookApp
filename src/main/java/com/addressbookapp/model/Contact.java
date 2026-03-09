package com.addressbookapp.model;

import java.util.Objects;

public class Contact {

	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	private String email;

	public Contact() {
	}

	public Contact(int id, String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNumber, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Contact(String firstName, String lastName, String address, String city, String state, String zip,
			String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "\n---------------Contact Details-----------" + "\nId: " + id + "\nFirst Name: " + firstName
				+ "\nLast Name: " + lastName + "\nAddress: " + address + "\nCity: " + city + "\nState: " + state
				+ "\nZip: " + zip + "\nPhone Number: " + phoneNumber + "\nEmail: " + email;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Contact)) {
			return false;
		}
		Contact other = (Contact) obj;
		return firstName.equalsIgnoreCase(other.firstName) && lastName.equalsIgnoreCase(other.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
	}
}