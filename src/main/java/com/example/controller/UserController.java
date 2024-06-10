package com.example.controller;
import com.example.Utils.Result;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public Result login(@RequestParam String username ,@RequestParam String password){
        String msg = userService.login(username, password);
        if ("unexist".equals(msg)){
            return Result.error("用户不存在！");
        }else if ("perror".equals(msg)){
            return Result.error("密码错误！");
        }
        return Result.success(msg);
    }
    @PostMapping("/register")
    public Result register(@RequestParam String username ,@RequestParam String password){
        String msg = userService.register(username,password);
        if ("success".equals(msg)){
            return Result.success("注册成功！");
        }else {
            return Result.error("用户已存在！");
        }
    }
    @RequestMapping("/")
    public void get(){

    }
}
