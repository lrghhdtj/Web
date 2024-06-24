package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    private int id; //题目编号
    private String title;
    private String description;
    private String data;
    private String question;
    private String solution;
    private String analysis;
    private String style;//类型

}
