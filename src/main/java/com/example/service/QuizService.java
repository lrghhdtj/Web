package com.example.service;

import com.example.Utils.Result;
import com.example.pojo.PageBean;

public interface QuizService {
    Result find(int quizid);
    Result get();
    PageBean page(Integer page, Integer pageSize);
}
