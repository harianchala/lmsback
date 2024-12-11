package com.klef.jfsd.springboot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.jfsd.springboot.model.Contact1;
import com.klef.jfsd.springboot.services.Contact1Service;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/faculty-contact")
public class Contact1Controller {

    @Autowired
    private Contact1Service contact1Service;

    @PostMapping("/add")
    public String addContact(@RequestBody Contact1 contact1) {
        contact1Service.addContact(contact1);
        return "Contact added successfully!";
    }

    @GetMapping("/all")
    public List<Contact1> displayAllContacts() {
        return contact1Service.displayAllContacts();
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody Contact1 contact1) {
        contact1Service.sendEmail(contact1);
        return "Email sent successfully!";
    }
}
