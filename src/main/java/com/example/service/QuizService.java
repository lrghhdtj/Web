package com.example.service;

import com.example.Utils.Result;
import com.example.pojo.PageBean;
import com.example.pojo.Quiz;

import java.util.ArrayList;

public interface QuizService {
    Result find(int id);
    Result get();
    PageBean page(Integer page, Integer pageSize);
}
