package com.example.service;

import com.example.Utils.Result;



public interface UserLogService {
    Result getUserLog(String username);

    Result delete(String username,int id);

    Result clear(String username);
    void add(String username, int quizid);
}
