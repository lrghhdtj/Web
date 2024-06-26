package com.example.service;

import com.example.Utils.Result;
import com.example.pojo.PageBean;
import com.example.pojo.Quiz;

import java.util.List;

public interface QuizService {
    Result find(int quizid);
    Result get();
    PageBean page(Integer page, Integer pageSize);
    List<Quiz> findByStyle(String style);
}
