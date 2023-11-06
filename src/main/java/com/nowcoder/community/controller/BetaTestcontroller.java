package com.nowcoder.community.controller;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.AlphaService;
import com.nowcoder.community.service.BetaTestService;
import com.nowcoder.community.service.DiscussPostService;
import com.nowcoder.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: huixiang0729
 * @Date: 2023-10-30  11:16
 */
@Controller
@RequestMapping("/beta")
public class BetaTestcontroller {
    @Autowired
    private BetaTestService betaTestService;
    @RequestMapping("/test")
    @ResponseBody
    public String show(){
        return betaTestService.getDao();
    }
    @Autowired
    private UserService userService;
    @Autowired
    private DiscussPostService discussPostService;
    @RequestMapping(path = "/test1200",method = RequestMethod.GET)
    @ResponseBody
    public String getInfoGet(){
        User uSerById = userService.findUSerById(149);
        System.out.println(uSerById);
        return "success";
    }
    @RequestMapping(path = "/test12000",method = RequestMethod.POST)
    @ResponseBody
    public String getInfoPost(){
        return "success2";
    }
    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model){
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, 0, 10);
        List<Map<String,Object>> discussposts=new ArrayList<>();
        if(list!=null){
            for(DiscussPost post:list){
                Map<String,Object> map=new HashMap<>();
                map.put("post",post);
                User user=userService.findUSerById(post.getUserId());
                map.put("user",user);
                discussposts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussposts);
        return "/index";
    }
    @RequestMapping("/test121/{id}")
    @ResponseBody
    public List<Map<String,Object>> getDiscussPosts(@PathVariable("id") int id){
        List<DiscussPost> list = discussPostService.findDiscussPosts(id, 0, 20);
        List<Map<String,Object>> map=new ArrayList<>();
        if(list!=null){
            for(DiscussPost discussPost:list){
                Map<String,Object> map1=new HashMap<>();
                map1.put("user",userService.findUSerById(discussPost.getUserId()));
                map1.put("post",discussPost);
                map.add(map1);
            }
        }
        return map;
    }
}
