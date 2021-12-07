package edu.soft2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {
    //接收处理数据
    //调用业务逻辑
    //页面跳转
    @RequestMapping(value = "/sayhello")
    public String sayHello(){
        System.out.println("hello springmvc!!");
        //url:/WEB-INF/pages/success.jsp
        return "success";//页面跳转(与视图解析器的前后缀拼接出url)
    }

    @RequestMapping("/sayHi")
    public String sayHi() {
        System.out.println("----sayHi()----");
        return "Hi";
    }
}
