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
    private int quizid;
    private String comment;
    private int goal;
    private Date createtime;

}
