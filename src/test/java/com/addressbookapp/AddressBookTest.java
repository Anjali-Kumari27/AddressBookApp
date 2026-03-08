package com.addressbookapp;

import com.addressbookapp.model.AddressBook;
import com.addressbookapp.model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressBookTest {

    @Test
    void givenNewContact_WhenAdded_ShouldReturnTrue() {
        AddressBook addressBook = new AddressBook();

        Contact contact = new Contact(
                "Anjali",
                "Singh",
                "GKP UP",
                "Gorakhpur",
                "UP",
                "273001",
                "9876543210",
                "anjali@example.com"
        );

        boolean result = addressBook.addContact(contact);

        Assertions.assertTrue(result);
        Assertions.assertEquals(1, addressBook.getContacts().size());
    }

    @Test
    void givenDuplicateContact_WhenAdded_ShouldReturnFalse() {
        AddressBook addressBook = new AddressBook();

        Contact contact1 = new Contact(
                "Anjali",
                "Singh",
                "GKP UP",
                "Gorakhpur",
                "UP",
                "273001",
                "9876543210",
                "anjali@example.com"
        );

        Contact contact2 = new Contact(
                "Anjali",
                "Singh",
                "Some Other Address",
                "Lucknow",
                "UP",
                "226001",
                "9999999999",
                "newmail@example.com"
        );

        addressBook.addContact(contact1);
        boolean result = addressBook.addContact(contact2);

        Assertions.assertFalse(result);
        Assertions.assertEquals(1, addressBook.getContacts().size());
    }

    @Test
    void givenTwoDifferentContacts_WhenAdded_ShouldReturnTrueForBoth() {
        AddressBook addressBook = new AddressBook();

        Contact contact1 = new Contact(
                "Anjali",
                "Singh",
                "GKP UP",
                "Gorakhpur",
                "UP",
                "273001",
                "9876543210",
                "anjali@example.com"
        );

        Contact contact2 = new Contact(
                "Riya",
                "Sharma",
                "Civil Lines",
                "Prayagraj",
                "UP",
                "211001",
                "9123456780",
                "riya@example.com"
        );

        boolean result1 = addressBook.addContact(contact1);
        boolean result2 = addressBook.addContact(contact2);

        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
        Assertions.assertEquals(2, addressBook.getContacts().size());
    }
}