package com.tfip2021.module2.service;

import com.tfip2021.module2.model.Contact;

public interface ContactsRepo {
    public void save(final Contact ctc);
    public String findById(final String contactId);
}
