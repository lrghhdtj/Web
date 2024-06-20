package com.example.service.impl;

import com.example.Utils.Result;
import com.example.mapper.CollectMapper;
import com.example.mapper.QuizMapper;
import com.example.pojo.Collect;
import com.example.pojo.Quiz;
import com.example.service.CollectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CollectServiceimpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;
    @Autowired
    QuizMapper quizMapper;
    @Override
    public Result findall(String username) {
        List<Integer> clist = collectMapper.getby(username);
        List<Quiz> list = new ArrayList<>();
        if (clist.size() > 0) {
            for (int i = 0; i < clist.size(); i++) {
                list.add(quizMapper.find(clist.get(i)));
            }
            return Result.success(list);
        }else {
            return Result.error("No Found!");
        }
    }

    @Override
    public Result add(String username, int quizid) {
        Collect collect =  collectMapper.get(username,quizid);
        if (collect != null){
            return Result.error("Quiz Exist");
        }else {
            collectMapper.add(username,quizid);
            return Result.success("加入成功！");
        }
    }

    @Override
    public Result delete(String username, int quizid) {
        Collect collect = collectMapper.get(username,quizid);
        if (collect == null){
            return Result.error("Collection No Exist");
        }else {
            collectMapper.delete(username,quizid);
            return Result.success("删除成功！");
        }
    }
}
