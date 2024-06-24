package com.example.controller;

import com.example.Utils.Result;
import com.example.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/get")
    public Result getComment(@RequestParam int quizid) {
        Result result;
        try {
            result = commentService.getcomment(quizid);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return result;
    }
    @PostMapping("/add")
    public Result addComment(@RequestParam String username,@RequestParam int quizid, @RequestParam String comment ,@RequestParam int goal) {
        Result result;
        try {
            result = commentService.addcomment(username,quizid,comment,goal);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return result;
    }
    @PostMapping("/delete")
    public Result deleteComment(@RequestParam String username,@RequestParam int quizid) {
        Result result;
        try {
            result = commentService.deletecomment(username,quizid);
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return result;
    }


}
