package com.example.controller;

import com.example.Utils.Result;
import com.example.pojo.Accept;
import com.example.pojo.Comment;
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
    public Result addComment(@RequestBody Comment comment) {
        Result result;
        try {
            result = commentService.addcomment(comment.getUsername(), comment.getQuizid(), comment.getComment(), comment.getGoal());
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return result;
    }
    @PostMapping("/delete")
    public Result deleteComment(@RequestBody Accept accept) {
        Result result;
        try {
            result = commentService.deletecomment(accept.getUsername(), accept.getQuizid());
        }catch (Exception e){
            e.printStackTrace();
            return Result.error(String.valueOf(e));
        }
        return result;
    }


}
