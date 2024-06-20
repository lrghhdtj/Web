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
        Result result = cs.findall(username);
        if (result.getCode() == 1){
            return result;
        }else {
            return Result.error("没有收藏!");
        }
    }
    @GetMapping("/add")
    public Result add(@RequestParam String username, @RequestParam int quizid) {
        Result result = cs.add(username,quizid);
        return result;

    }
    @GetMapping("/delete")
    public Result delete(@RequestParam String username, @RequestParam int quizid) {
        Result result = cs.delete(username,quizid);
        return result;

    }

}
