package com.example.Utils;

public class Check {


    public static Result check(String answer,String solution) {
        if (answer.matches("[a-zA-Z]+")) {
            int[] msg = new int[solution.length()];
            if (answer.length() == solution.length()) {
                answer = answer.toLowerCase();
                solution = solution.toLowerCase();
                int count = 0;
                for (int i = 0; i < answer.length(); i++) {
                    if (answer.charAt(i) == solution.charAt(i)) {
                        msg[i] = 1;
                        count++;
                    }
                }

                return Result.success(msg);
            } else {
                return Result.error("答案不完整！");
            }
        }else {
            return Result.error("答案有误！");
        }
    }


}
