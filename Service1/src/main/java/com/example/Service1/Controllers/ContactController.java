package com.example.Service1.Controllers;

import com.example.Service1.Entities.Contact;
import com.example.Service1.Services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.addContact(contact);
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }

    @GetMapping("/search")
    public List<Contact> searchContacts(@RequestParam String query) {
        return contactService.searchContacts(query);
    }

    @GetMapping("/searchByName")
    public List<Contact> searchByName(@RequestParam String name) {
        return contactService.findByName(name);
    }

    @GetMapping("/invalidPhones")
    public List<Contact> findInvalidPhoneNumbers() {
        return contactService.findInvalidPhoneNumbers();
    }

}

