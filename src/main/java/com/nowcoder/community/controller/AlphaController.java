package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: huixiang0729
 * @Date: 2023-10-28  22:10
 */
@Controller
@RequestMapping("/alpha")

public class AlphaController {
    @Autowired
    private AlphaService alphaService;
    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "hello spring ls";
    }

    @RequestMapping("http")
    public void http(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            String header = request.getHeader(s);
            System.out.println(s+":"+header);
        }
        System.out.println(request.getParameter("code"));
        //返回响应数据
        response.setContentType("test/html:charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("<h1>牛客网</h1>");
        writer.close();
    }
    //GET
    //student?curentr=1&limit=20
    @RequestMapping(path = "student",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(
            @RequestParam(name = "current",required = false,defaultValue = "1") int current,
            @RequestParam(name = "limit",required = false,defaultValue = "20") int limit){
        return "some student";
    }
//student/123
    @RequestMapping(path = "student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStuden(@PathVariable("id") int id){
        System.out.println(id);
        return "student";
    }
    //POST请求
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStu(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }
    //响应html数据
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","张三");
        modelAndView.addObject("age","30");
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }
    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","北京工业大学");
        model.addAttribute("age","30");
        return "/demo/view";
    }
    //响应json数据
    //异步请求
    //JAVA对象-》Json字符串-》JS对象
    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> mp=new HashMap<>();
        mp.put("name","张三");
        mp.put("age","23");
        return mp;
    }
}
