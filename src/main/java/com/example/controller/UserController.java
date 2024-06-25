package com.example.controller;
import com.example.Utils.Result;
import com.example.pojo.User;
import com.example.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    //public Result login(@RequestParam String username ,@RequestParam  String password ){
    public Result login(@RequestBody User user ){
        return userService.login(user.getUsername(), user.getPassword());
    }
    @PostMapping("/register")
    public Result register(@RequestBody User user ){
        return userService.register(user.getUsername(), user.getPassword());
    }

    @PostMapping("/change")
    public Result change(@RequestBody usertmp usertmp ){
        return  userService.change(usertmp.getUsername(),usertmp.getOldpassword(),usertmp.getNewpassword());

    }

}
@Data
@AllArgsConstructor
@NoArgsConstructor
class usertmp{
    private String username;
    private String oldpassword;
    private String newpassword;
}