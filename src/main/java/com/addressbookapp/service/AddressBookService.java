package com.addressbookapp.service;

import com.addressbookapp.model.Contact;

import java.util.List;

public interface AddressBookService {
	List<Contact> getAllContactsFromDB();
}