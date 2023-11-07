package com.nowcoder.community.service;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.util.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.thymeleaf.TemplateEngine;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: huixiang0729
 * @Date: 2023-10-30  21:09
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MailClient mailClient;
    @Autowired
    private TemplateEngine templateEngine;//不使用ResquestMapping自动跳转时，使用thymeleaf跳转
    @Value("${community.path.domain}")
    private String dimain;
    @Value("${server.serverlet.context-path}")
    private String contextPath;
    public User findUSerById(int id){
        return userMapper.selectById(id);
    }
    public Map<String,Object> register(User user){
        Map<String,Object> map=new HashMap<>();
        //对空值处理
        if(user==null){
            throw new IllegalArgumentException("参数不能为空！");
        }
        if(StringUtils.isEmpty(user.getUsername())){

        }
        return null;
    }
}
