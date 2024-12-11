package com.klef.jfsd.springboot.services;
import org.springframework.scheduling.annotation.Async;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Contact1;
import com.klef.jfsd.springboot.repository.Contact1Repository;

@Service
public class Contact1ServiceImpl implements Contact1Service {

    @Autowired
    private Contact1Repository contactRepository;

    @Autowired
    private JavaMailSender mailSender;
    
    @Override
    public void addContact(Contact1 contact1) {
        contactRepository.save(contact1);
    }

    @Override
    public List<Contact1> displayAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    @Async
    public void sendEmail(Contact1 contact1) {
        // Create a new SimpleMailMessage object
        SimpleMailMessage message = new SimpleMailMessage();
        
        // Set the properties for the email
        message.setTo(contact1.getFromMail());
        message.setSubject(contact1.getSubject());
        message.setText(contact1.getText());
        message.setFrom("yarrapothuravikumar2004@gmail.com"); // Set the sender email

        // Send the email using JavaMailSender
        mailSender.send(message);
        
        // For debugging purposes, log the email details
        System.out.println("Email sent to: " + contact1.getFromMail());
        System.out.println("Subject: " + contact1.getSubject());
        System.out.println("Message: " + contact1.getText());
    }
}