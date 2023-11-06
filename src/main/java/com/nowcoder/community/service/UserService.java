package com.nowcoder.community.service;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: huixiang0729
 * @Date: 2023-10-30  21:09
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User findUSerById(int id){
        return userMapper.selectById(id);
    }
}
