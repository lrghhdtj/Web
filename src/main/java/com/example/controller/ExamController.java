package com.example.controller;

import com.example.Utils.Result;
import com.example.pojo.Quiz;
import com.example.service.QuizService;
import com.example.service.UserLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    QuizService quizService;
    @Autowired
    UserLogService userLogService;
    @GetMapping("/test")
    public Result doexam(@RequestParam String username) {
        List<Quiz> list;
        try {
            list = ((List<Quiz>) quizService.get().getData());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
        List<Quiz> r = new ArrayList<>();
        List<Quiz> f = new ArrayList<>();
        List<Quiz> t = new ArrayList<>();
        List<Quiz> w = new ArrayList<>();
        List<Quiz> paper = new ArrayList<>();
        for (Quiz quiz : list) {
            if (quiz.getStyle().equals("r")) {
                r.add(quiz);
            }
            if (quiz.getStyle().equals("f")) {
                f.add(quiz);
            }
            if (quiz.getStyle().equals("t")) {
                t.add(quiz);
            }
            if (quiz.getStyle().equals("w")) {
                w.add(quiz);
            }
        }
        Collections.shuffle(r);
        Collections.shuffle(f);
        Collections.shuffle(t);
        Collections.shuffle(w);
        for (int i = 0; i < 3; i++) {
            paper.add(r.get(i));
        }
        paper.add(f.get(1));
        userLogService.add(username,f.get(1).getId());
        paper.add(t.get(1));
        userLogService.add(username,t.get(1).getId());
        paper.add(w.get(1));
        userLogService.add(username,w.get(1).getId());
        return Result.success(paper);
    }

}
