package com.addressbookapp.model;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public boolean addContact(Contact newContact) {
        boolean isDuplicate = contacts.stream()
                .anyMatch(existingContact -> existingContact.equals(newContact));

        if (isDuplicate) {
            return false;
        }

        contacts.add(newContact);
        return true;
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}