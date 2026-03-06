package com.addressbookapp;

import com.addressbookapp.model.Contact;

public class AddressBookMain {

    public static void start() {

        System.out.println("Welcome to Address Book Program");

        Contact contact = new Contact(
                "Anjali",
                "Singh",
                "123 MG Road",
                "Bhopal",
                "Madhya Pradesh",
                "462001",
                "9876543210",
                "anjali@example.com"
        );

        System.out.println("\nContact Created Successfully!");
        System.out.println(contact);
    }
}