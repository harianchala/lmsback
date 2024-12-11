package com.klef.jfsd.springboot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.jfsd.springboot.model.Contact;
import com.klef.jfsd.springboot.services.ContactService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/student-contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/add")
    public String addContact(@RequestBody Contact contact) {
        contactService.addContact(contact);
        return "Contact added successfully!";
    }

    @GetMapping("/all")
    public List<Contact> displayAllContacts() {
        return contactService.displayAllContacts();
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody Contact contact) {
        contactService.sendEmail(contact);
        return "Email sent successfully!";
    }
}
