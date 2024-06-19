package com.bekprotek.bekprotek.controllers;

import org.springframework.web.bind.annotation.*;
import com.bekprotek.bekprotek.entities.*;
import com.bekprotek.bekprotek.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/adress")
public class AdressbookResource {

    private final AdressbookService service;

    @Autowired
    public AdressbookResource (AdressbookService service)
    {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> getContacts() {
        return new ResponseEntity<>(service.getContacts(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable("id") Long id) {
        Optional<Contact> optionalContact = service.getContact(id);

        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
