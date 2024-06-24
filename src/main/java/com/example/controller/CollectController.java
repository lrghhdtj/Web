package com.example.controller;

import com.example.Utils.Result;
import com.example.service.CollectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    CollectService cs;
    @GetMapping("/view")
    public Result view(@RequestParam String username) {
        Result result = new Result();
        try {
            result = cs.findall(username);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return result;
    }
    @GetMapping("/add")
    public Result add(@RequestParam String username, @RequestParam int quizid) {
        Result result = new Result();
        try {
             result = cs.add(username,quizid);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return result;
    }
    @GetMapping("/delete")
    public Result delete(@RequestParam String username, @RequestParam int quizid) {
        Result result = new Result();
        try {
            result = cs.delete(username,quizid);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return result;
    }

    }


