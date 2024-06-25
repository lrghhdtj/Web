package com.example.service;

import com.example.Utils.Result;

public interface UserService {
    Result login(String username , String password);
    Result register(String username , String password);
    Result change(String username, String oldpassword, String newpassword);
}
