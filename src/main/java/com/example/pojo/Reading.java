package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reading {
    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private String question5;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
}
