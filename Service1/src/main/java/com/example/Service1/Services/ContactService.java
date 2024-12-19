package com.example.Service1.Services;

import com.example.Service1.Entities.Contact;
import com.example.Service1.Repos.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    public List<Contact> searchContacts(String query) {
        return contactRepository.findAll().stream()
                .filter(contact -> contact.getNomPrenom().contains(query) ||
                        contact.getAdresse().getCodePostalVille().contains(query))
                .collect(Collectors.toList());
    }

    public List<Contact> findByName(String name) {
        return contactRepository.findAll().stream()
                .filter(contact -> contact.getNomPrenom().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Contact> findInvalidPhoneNumbers() {
        return contactRepository.findAll().stream()
                .filter(contact -> !contact.getTelephone().matches("\\d{8}"))
                .collect(Collectors.toList());
    }

}
