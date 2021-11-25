package com.playup.service;

import com.playup.constants.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements IEmailSender {

    @Autowired
    private JavaMailSender mailSender;


    @Override
    public void sendEmail(String  toEmail, String body, String subject){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(ApplicationConstants.adminMailId);
        message.setTo(toEmail);
        message.setText(body);
        
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Email send");
    }

}
