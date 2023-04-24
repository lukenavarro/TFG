package com.example.demo.services;

import com.example.demo.model.entities.User;


public interface UserService {

    User getUserWithUserNameAndPassword(String user, String password);

    User addUser(User user);
}
