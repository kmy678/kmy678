package edu.soft2.controller;

import edu.soft2.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "user")
public class UserController {
    //删除操作
    @RequestMapping(value = "delete")
    public String delete() {
        System.out.println("--------delete()-------");
        return "hello";
    }
    @RequestMapping(value = "login")
    public String login(User user, HttpSession session, HttpServletRequest request) {
        System.out.println("-------login()-------");
        int flag = 1; //调用业务层,获取返回值
        if (flag == 1) {
            session.setAttribute("user",user);
            return "welcome";
        }
        return "hello";
    }
    @RequestMapping(value = "hello")
    public String hello(){
        System.out.println("----hello()----");
        return "hello";
    }

}
