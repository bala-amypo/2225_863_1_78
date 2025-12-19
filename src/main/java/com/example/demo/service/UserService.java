package com.example.demo.service;

import com.example.demo.model.UserModel;

public interface UserService {

    UserModel createUser(UserModel user);

    UserModel loginUser(String email, String password);
}
