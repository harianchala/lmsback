package com.klef.jfsd.springboot.services;
import java.util.List;

import com.klef.jfsd.springboot.model.Contact1;

public interface Contact1Service {
    void addContact(Contact1 contact1);          // Function to add a new contact
    List<Contact1> displayAllContacts();        // Function to display all contacts
    void sendEmail(Contact1 contact1);           // Function to send an email
}