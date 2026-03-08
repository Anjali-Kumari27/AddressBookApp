package com.addressbookapp;

import com.addressbookapp.model.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

	@Test
	public void givenValidContactDetails_whenObjectCreated_shouldNotReturnNull() {

		Contact contact = new Contact("Anjali", "Singh", "123 MG Road", "Bhopal", "Madhya Pradesh", "462001",
				"9876543210", "anjali@example.com");

		assertNotNull(contact);
	}

	@Test
	public void givenValidContactDetails_whenToStringCalled_shouldContainFirstName() {

		Contact contact = new Contact("Anjali", "Singh", "123 MG Road", "Bhopal", "Madhya Pradesh", "462001",
				"9876543210", "anjali@example.com");

		String result = contact.toString();

		assertTrue(result.contains("Anjali"));
	}

	@Test
	public void givenValidContactDetails_whenToStringCalled_shouldContainLastName() {

		Contact contact = new Contact("Anjali", "Singh", "123 MG Road", "Bhopal", "Madhya Pradesh", "462001",
				"9876543210", "anjali@example.com");

		String result = contact.toString();

		assertTrue(result.contains("Singh"));
	}

	@Test
	public void givenValidContactDetails_whenToStringCalled_shouldContainCity() {

		Contact contact = new Contact("Anjali", "Singh", "123 MG Road", "Bhopal", "Madhya Pradesh", "462001",
				"9876543210", "anjali@example.com");

		String result = contact.toString();

		assertTrue(result.contains("Bhopal"));
	}

	@Test
	public void givenValidContactDetails_whenToStringCalled_shouldContainPhoneNumber() {

		Contact contact = new Contact("Anjali", "Singh", "123 MG Road", "Bhopal", "Madhya Pradesh", "462001",
				"9876543210", "anjali@example.com");

		String result = contact.toString();

		assertTrue(result.contains("9876543210"));
	}

	@Test
	public void givenTwoContactsWithSameName_whenCompared_shouldBeEqual() {

		Contact contact1 = new Contact("Anjali", "Singh", "123 MG Road", "Bhopal", "Madhya Pradesh", "462001",
				"9876543210", "anjali@example.com");

		Contact contact2 = new Contact("Anjali", "Singh", "45 Lake View", "Indore", "Madhya Pradesh", "452001",
				"9999999999", "anjali2@example.com");

		assertEquals(contact1, contact2);
	}

	@Test
	public void givenTwoContactsWithDifferentName_whenCompared_shouldNotBeEqual() {

		Contact contact1 = new Contact("Anjali", "Singh", "123 MG Road", "Bhopal", "Madhya Pradesh", "462001",
				"9876543210", "anjali@example.com");

		Contact contact2 = new Contact("Rahul", "Verma", "45 Lake View", "Indore", "Madhya Pradesh", "452001",
				"9999999999", "rahul@example.com");

		assertNotEquals(contact1, contact2);
	}
}