package com.klef.jfsd.springboot.services;

import java.util.List;

import com.klef.jfsd.springboot.model.Contact;

public interface ContactService {
    void addContact(Contact contact);          // Function to add a new contact
    List<Contact> displayAllContacts();        // Function to display all contacts
    void sendEmail(Contact contact);           // Function to send an email
}