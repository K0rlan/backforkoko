package com.example.backforkoko.controller;

import com.example.backforkoko.model.User;
import com.example.backforkoko.service.EmailSendService;
import com.example.backforkoko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmailSendService emailSend;
    int curr_id;
    @PostMapping("/create")
    public void addUser(@RequestBody User user) {
        User newuser = userService.addUser(user);
        curr_id = user.getId();
        System.out.println(curr_id);
        emailSend.sendEmail(curr_id);
    }

}
