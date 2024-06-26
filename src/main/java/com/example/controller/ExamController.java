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
        List<Quiz> r;
        List<Quiz> f;
        List<Quiz> t;
        List<Quiz> w;
        try {
            r = quizService.findByStyle("reading");
            f = quizService.findByStyle("filling");
            t = quizService.findByStyle("translation");
            w = quizService.findByStyle("writing");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }
        List<Quiz> paper = new ArrayList<>();
        Collections.shuffle(r);
        Collections.shuffle(f);
        Collections.shuffle(t);
        Collections.shuffle(w);
        for (int i = 0; i < 3; i++) {
            paper.add(r.get(i));
        }
        paper.add(f.get(1));
        userLogService.add(username, f.get(1).getId());
        paper.add(t.get(1));
        userLogService.add(username, t.get(1).getId());
        paper.add(w.get(1));
        userLogService.add(username, w.get(1).getId());
        return Result.success(paper);
    }

}
