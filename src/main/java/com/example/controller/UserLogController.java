package com.example.controller;

import com.example.Utils.Result;
import com.example.service.UserLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/userlog")
public class UserLogController {
    @Autowired
    UserLogService userLogService;
    @GetMapping("/get")
    public Result getUserLog(@RequestParam String username) {
        return userLogService.getUserLog(username);
    }
    @GetMapping("/delete")
    public Result delete(@RequestParam String username,@RequestParam int id) {
        return userLogService.delete(username,id);
    }
    @GetMapping("/clear")
    public Result clear(@RequestParam String username) {
        return userLogService.clear(username);
    }

}
