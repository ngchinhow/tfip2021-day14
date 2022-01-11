package com.tfip2021.module2.model;

import java.io.Serializable;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Contact implements Serializable {
    private static final int ID_LENGTH = 8;

    private String id;
    private String name;
    private String email;
    private String phoneNumber;

    public Contact() {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < ID_LENGTH){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        this.id = sb.toString().substring(0, ID_LENGTH);
    }

    public Contact(String id) {
        this.id = id;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public String toString() {
        return "id=" + getId() + ";" +
            "name=" + getName() + ";" +
            "email=" + getEmail() + ";" +
            "phoneNumber=" + getPhoneNumber();
    }
}
