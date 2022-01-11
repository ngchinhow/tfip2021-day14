package com.tfip2021.module2.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.tfip2021.module2.model.Contact;
import com.tfip2021.module2.service.ContactsRedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(path = { "/contact" })
public class ContactResource {
    @Autowired
    private ContactsRedis service;

    @GetMapping("/{id}")
    public String getContact(@PathVariable("id") String id, Model model) throws FileNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        Contact contact = service.findById(id);
        model.addAttribute("id", contact.getId());
        model.addAttribute("name", contact.getName());
        model.addAttribute("email", contact.getEmail());
        model.addAttribute("phoneNumber", contact.getPhoneNumber());
        
        return "retrieved";
    }

    @PostMapping(
        consumes="application/x-www-form-urlencoded",
        produces = { "text/html" }
    )
    @ResponseStatus(code = HttpStatus.CREATED)
    public String createContact(@ModelAttribute Contact contact, Model model) throws IOException {
        service.save(contact);
        model.addAttribute("id", contact.getId());
        model.addAttribute("name", contact.getName());
        model.addAttribute("email", contact.getEmail());
        model.addAttribute("phoneNumber", contact.getPhoneNumber());
        return "created";
    }
}
