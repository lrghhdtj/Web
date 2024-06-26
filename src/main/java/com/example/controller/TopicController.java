package com.example.controller;

import com.example.Utils.Check;
import com.example.Utils.Result;
import com.example.pojo.PageBean;
import com.example.pojo.Quiz;
import com.example.service.QuizService;
import com.example.service.UserLogService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    QuizService quizService;
    @Autowired
    UserLogService userLogService;
    @RequestMapping("")
    public Result home() {
        //返回评分最高的前5道题
        List<tmp> tmpList;
        try {
            tmpList = new ArrayList<>();
            List<Quiz> list = (List<Quiz>) quizService.top().getData();
            for (int i = list.size()-1; i >= 0; i--) {
                tmp tmp = new tmp(list.get(i).getId(),list.get(i).getTitle(),list.get(i).getDescription());
                tmpList.add(tmp);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return Result.success(tmpList);
    }

    @RequestMapping("/")
    public Result get() {
        Result result;
        try {
            result = quizService.get();
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return result;
    }
//找题
    @GetMapping(value = {"/find"})
    public Result find(@RequestParam int quizid) {
        Result result;
        try {
            result = quizService.find(quizid);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return result;
    }
    //做题
    @GetMapping(value = {"/do"})
    public Result doquiz(@RequestParam int quizid,@RequestParam String username) {
        Result result;
        try {
            result = quizService.find(quizid);
            userLogService.add(username,quizid);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return result;
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
    @GetMapping("/check")
    public Result check(@RequestParam int quizid, @RequestParam String answer) {
        Quiz quiz = (Quiz) quizService.find(quizid).getData();
        Check check = new Check();
        return  check.check(answer, quiz.getSolution());
    }


}
@Data
@NoArgsConstructor
@AllArgsConstructor
class tmp{
    private int id;
    private String title;
    private String description;

    }
