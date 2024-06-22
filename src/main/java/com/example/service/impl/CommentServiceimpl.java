package com.example.service.impl;

import com.example.Utils.Result;
import com.example.mapper.CommentMapper;
import com.example.pojo.Comment;
import com.example.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceimpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public Result getcomment(int quizid) {
        List<Comment> list = commentMapper.selectAll(quizid);
        if (list.size() > 0) {
            return Result.success(list);
        }else {
            return Result.error("没有评论！");
        }
    }

    @Override
    public Result addcomment(String username, int quizid, String comment, int goal) {
        Comment c = commentMapper.get(username,quizid);
        if (c == null){
            Date createtime = new Date();
            commentMapper.addcomment(username,quizid,comment,goal,new Timestamp(createtime.getTime()));
            return Result.success("评论成功！");
        }else {
            return Result.error("已评论！");
        }
    }

    @Override
    public Result deletecomment(String username, int quizid) {
        Comment c = commentMapper.get(username,quizid);
        if (c != null){
            commentMapper.deletecomment(username,quizid);
            return Result.success("成功删除评论！");
        }else {
            return Result.error("未找到评论！");
        }
    }


}
