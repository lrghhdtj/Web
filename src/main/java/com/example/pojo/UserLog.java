package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLog {
    private int id;
    private String title;
    private int userid;
    private int quizid;
    private Date time;
}
