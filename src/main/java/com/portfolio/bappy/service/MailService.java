package com.portfolio.bappy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    String to = "sohanbappy@gmail.com";

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String email,String name,String subject,String message){
        try {
            // Create a mail sender and adding Values
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(email);
            mailMessage.setTo(to);
            mailMessage.setSubject("Portfolio-mail About: "+subject+" <from> "+name+"("+email+")");
            mailMessage.setText(message);
            // Send mail
            mailSender.send(mailMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
