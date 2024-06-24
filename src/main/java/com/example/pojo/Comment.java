package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int id;
    private String username;
    private String comment;
    private int goal;
    private Date createtime;
    private int userid;
    private int quizid;

}
