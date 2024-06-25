package com.example.service.impl;

import com.example.Utils.Result;
import com.example.mapper.UserLogMapper;
import com.example.mapper.UserMapper;
import com.example.service.UserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class UserLogServiceimpl implements UserLogService {
    @Autowired
    UserLogMapper userLogMapper;
    @Autowired
    UserMapper userMapper;
    int userid;

    @Override
    public Result getUserLog(String username) {
        userid = userMapper.getUserid(username);
        return Result.success(userLogMapper.get(userid));
    }

    @Override
    public Result delete(String username,int id) {
        userid = userMapper.getUserid(username);
        userLogMapper.delete(userid,id);
        return Result.success();
    }

    @Override
    public Result clear(String username) {
        userid = userMapper.getUserid(username);
        userLogMapper.clear(userid);
        return Result.success();
    }
    @Override
    public void add(String username,int quizid){
        userid = userMapper.getUserid(username);
        Date time = new Date();
        userLogMapper.add(userid,quizid,new Timestamp(time.getTime()));
    }
}
