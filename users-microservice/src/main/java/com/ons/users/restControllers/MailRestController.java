package com.ons.users.restControllers;

import com.ons.users.service.MailService;

import com.ons.users.mail.Mail;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class MailRestController {
    @Autowired
    private MailService mailService;

    @PostMapping("/send/{email}")
    public String sendMail (@PathVariable String email, @RequestBody Mail mail) {
        mailService.sendMail(email, mail);
        return "Mail sent successfully";
    }
}