package com.example.service.impl;

import com.example.Utils.Result;
import com.example.mapper.QuizMapper;
import com.example.pojo.PageBean;
import com.example.pojo.Quiz;
import com.example.service.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class QuizServiceimpl implements QuizService {
    @Autowired
    QuizMapper quizMapper;
    @Override
    public Result find(int id) {
        Quiz quiz = quizMapper.find(id);
        if (quiz != null){
            return Result.success(quiz);
        }else {
            return Result.error("没有找到题目!");
        }
    }
    @Override
    public Result get(){
        List<Quiz> list = quizMapper.get();
        if (!list.isEmpty()){
            return Result.success(list);
        }else {
            return Result.error("没有找到题目!");
        }
    }
    @Override
    public PageBean page(Integer page, Integer pageSize) {
        Long count = quizMapper.count();
        Integer startIndex = (page - 1) * pageSize;
        List<Quiz> empList = quizMapper.page(startIndex, pageSize);
        PageBean pageBean = new PageBean(count, empList);
        return pageBean;
    }

}
