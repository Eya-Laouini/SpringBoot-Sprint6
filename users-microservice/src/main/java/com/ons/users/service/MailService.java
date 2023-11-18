package com.ons.users.service;
import com.ons.users.mail.Mail;
public interface MailService {
    void sendMail(String email, Mail mail);
}
