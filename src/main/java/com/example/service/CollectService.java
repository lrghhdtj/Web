package com.example.service;

import com.example.Utils.Result;

public interface CollectService {
    Result findall(int userid);
    Result add(int userid,int quizid);
    Result delete(int userid,int quizid);
}
