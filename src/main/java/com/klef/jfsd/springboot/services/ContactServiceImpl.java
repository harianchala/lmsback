package com.klef.jfsd.springboot.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Contact;
import com.klef.jfsd.springboot.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    
    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public List<Contact> displayAllContacts() {
        return contactRepository.findAll();
    }

    public void sendEmail(Contact contact) {
        // Create a new SimpleMailMessage object
        SimpleMailMessage message = new SimpleMailMessage();
        
        // Set the properties for the email
        message.setTo(contact.getFromMail());
        message.setSubject(contact.getSubject());
        message.setText(contact.getText());
        message.setFrom("yarrapothuravikumar2004@gmail.com"); // Set the sender email

        // Send the email using JavaMailSender
        mailSender.send(message);
        
        // For debugging purposes, log the email details
        System.out.println("Email sent to: " + contact.getFromMail());
        System.out.println("Subject: " + contact.getSubject());
        System.out.println("Message: " + contact.getText());
    }
}