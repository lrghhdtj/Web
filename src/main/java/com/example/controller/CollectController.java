package com.example.controller;

import com.example.Utils.Result;
import com.example.pojo.Accept;
import com.example.pojo.Collect;
import com.example.service.CollectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @PostMapping("/add")
    public Result add(@RequestBody Accept accept) {
        Result result;
        try {
             result = cs.add(accept.getUsername(), accept.getQuizid());
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return result;
    }
    @PostMapping("/delete")
    public Result delete(@RequestBody Accept accept) {
        Result result;
        try {
            result = cs.delete(accept.getUsername(), accept.getQuizid());
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return result;
    }

    }


