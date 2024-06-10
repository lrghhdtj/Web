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
    public Result view(@RequestParam int userid, @RequestParam int quizid) {
        Result result = cs.findall(userid);
        if (result.getCode() == 1){
            return result;
        }else {
            return Result.error("");
        }
    }
    @GetMapping("/add")
    public Result add(@RequestParam int userid, @RequestParam int quizid) {
        Result result = cs.add(userid,quizid);
        return result;

    }
    @GetMapping("/delete")
    public Result delete(@RequestParam int userid, @RequestParam int quizid) {
        Result result = cs.delete(userid,quizid);
        return result;

    }

}
