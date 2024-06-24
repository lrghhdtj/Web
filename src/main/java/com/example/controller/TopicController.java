package com.example.controller;

import com.example.Utils.Check;
import com.example.Utils.Result;
import com.example.pojo.PageBean;
import com.example.pojo.Quiz;
import com.example.service.QuizService;
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
    @RequestMapping("")
    public Result home() {

        List<tmp> tmpList;
        try {
            tmpList = new ArrayList<>();
            List<Quiz> list = (List<Quiz>) quizService.get().getData();
            System.out.println(list.size());
            for (int i = list.size()-1; i >= 0; i--) {
                System.out.println(list.get(i).getId());
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
    @GetMapping(value = {"/find","/do"})
    public Result find(@RequestParam int id) {
        Result result;
        try {
            result = quizService.find(id);
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
class tmp{
    private int id;
    private String title;
    private String description;
    public tmp(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public tmp() {
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}