package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: huixiang0729
 * @Date: 2023-10-29  21:33
 */
@Service
@Scope("prototype")
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;
    public AlphaService(){
        System.out.println("实例化AlphaService");
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化AlphaService");
    }
    @PreDestroy
    public void destory(){
        System.out.println("销毁AlphaService");
    }
    public String find(){
        return alphaDao.select();
    }
}
