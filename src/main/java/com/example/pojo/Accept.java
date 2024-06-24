package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Accept {
    private int id;
    private String comment;
    private int goal;
    private Date createtime;
    private int userid;
    private int quizid;
    //user
    private String username;
    private String password;
    //题目
    private String title;
    private String description;
    private String data;
    private String question;
    private String solution;
    private String analysis;
    private String style;//类型
}
