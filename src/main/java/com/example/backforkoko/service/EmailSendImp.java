package com.example.backforkoko.service;

import com.example.backforkoko.mail.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendImp implements EmailSendService {
    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    private UserService userService;
    @Override
    public void sendEmail(Integer curr) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(MyConstants.to_email);
            message.setSubject(userService.getUserById(curr).getTitle());
            message.setText(userService.getUserById(curr).getMessage());
            this.emailSender.send(message);

            SimpleMailMessage message2 = new SimpleMailMessage();
            message2.setTo(userService.getUserById(curr).getEmail());
            message2.setSubject("Omarova Korlan");
            message2.setText("Thanks, for attention!");
            this.emailSender.send(message2);
    }
}
