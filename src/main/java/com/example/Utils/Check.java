package com.example.Utils;

public class Check {
    public static Result reading_check(String answer,String solution) {
        String [] msg = new String[answer.length()];
        for(int i=0;i<answer.length();i++) {
            if(answer.charAt(i) != solution.charAt(i)) {
                msg[i] =   "第"+i+1+ "题错误";
            }
        }
        return Result.success(msg);
    }
}
