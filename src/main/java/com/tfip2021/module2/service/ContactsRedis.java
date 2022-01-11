package com.tfip2021.module2.service;

import com.tfip2021.module2.model.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ContactsRedis implements ContactsRepo {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(final Contact ctc) {
        redisTemplate.opsForValue().set(ctc.getId(), ctc);
    }

    @Override
    public Contact findById(final String contactId) {
        return (Contact) redisTemplate.opsForValue().get(contactId);
    }
}