package com.example.ss3_1.service;

import com.example.ss3_1.model.MailBox;
import com.example.ss3_1.repository.IMailboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailboxService implements IMailboxService {
    @Autowired
    private IMailboxRepository mailboxRepository;
    @Override
    public MailBox save(MailBox mailBox) {
        return null;
    }
}
