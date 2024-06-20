package com.example.service;

import com.example.Utils.Result;

public interface CollectService {
    Result findall(String username);
    Result add(String username,int quizid);
    Result delete(String username,int quizid);
}
