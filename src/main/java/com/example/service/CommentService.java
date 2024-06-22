package com.example.service;

import com.example.Utils.Result;

public interface CommentService {
    Result getcomment(int quizid);

    Result addcomment(String username, int quizid, String comment, int goal);

    Result deletecomment(String username, int quizid);


}
