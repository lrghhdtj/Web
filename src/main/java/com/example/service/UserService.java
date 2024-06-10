package com.example.service;

import com.example.pojo.User;

public interface UserService {
    String login(String usernmae , String password);
    String register(String usernmae , String password);
}
