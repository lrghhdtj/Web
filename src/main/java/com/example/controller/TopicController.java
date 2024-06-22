package com.example.controller;

import com.example.Utils.Check;
import com.example.Utils.Result;
import com.example.pojo.PageBean;
import com.example.pojo.Quiz;
import com.example.service.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    QuizService quizService;

    @RequestMapping("/")
    public Result get() {
        Result result = quizService.get();
        if (result.getCode() == 1){
            return result;
        }else {
            return Result.error("error");
        }
    }
//找题
    @GetMapping(value = {"/find","/do"})
    public Result find(@RequestParam int id) {
        Result result = quizService.find(id);
        if (result.getCode() == 1) {
            return Result.success();
        } else {
            return Result.error("没找到题目！");
        }
    }
//分页查询
    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
//        设置默认值
//        if(page==null) page=1;
//        if(pageSize==null) pageSize=10;
        PageBean pageBean = quizService.page(page, pageSize);
        return Result.success(pageBean);
    }
//检查答案
    @PostMapping("/check")
    public Result check(@RequestParam int quizid, @RequestParam String answer) {
        Quiz quiz = (Quiz) quizService.find(quizid).getData();
        Check check = new Check();
        return  check.check(answer, quiz.getSolution());

    }


}