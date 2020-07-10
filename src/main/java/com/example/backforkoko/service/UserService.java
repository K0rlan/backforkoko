package com.example.backforkoko.service;

import com.example.backforkoko.model.User;

public interface UserService {
    User addUser(User user);
    User getUserById(Integer id);
}
