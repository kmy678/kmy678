package edu.soft2.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "param1")
public class MyController {  //handle

    @RequestMapping(value = "/sayHello",method = {RequestMethod.GET,RequestMethod.POST})
    public String sayHello(HttpServletRequest request){
        //1.接受处理数据
        String name = request.getParameter("name");//通过参数名(url),获取参数值
        System.out.println("获取参数name值为"+name);
        //2.调用业务逻辑(n/a)
        //3.页面跳转
        System.out.println("hello springmvc！！！");
        // url: /WEB-INF/pages/xxx.jsp
        return "success";//页面跳转(与视图解析器的前后缀拼接出url)
        //默认用转发的方式跳转
    }
    @RequestMapping(value = "/param1",method = {RequestMethod.GET,RequestMethod.POST})
    public String param1(HttpServletRequest request) {//这个方法对应的usrl路径：http://localhost:8080/[项目名]/hello.do
        System.out.println("--------param1-------");
        String username = request.getParameter("username");//通过参数名(url),获取参数值
        String age = request.getParameter("age");//通过参数名(url),获取参数值
        System.out.println("username="+username+" age="+age);
        request.setAttribute("username",username);//将数据放入request
        request.setAttribute("age",age);
        //调用业务跳转页面
        return "hello";//拼写url：/WEB-INF/pages/hello.jsp
    }

    @RequestMapping(value = "/param2")
    public String param2(HttpServletRequest request) {
        System.out.println("-------param2-------");
        String username = request.getParameter("username");//通过参数名(url),获取参数值
        String age = request.getParameter("age");//通过参数名(url),获取参数值
        System.out.println("username="+username+" age="+age);
        request.setAttribute("username",username);//将数据放入request
        request.setAttribute("age",age);
        return "redirect:/hello";//重定向跳转
    }

    @RequestMapping(value = "/param3")
    public String param3(HttpServletRequest request,HttpSession session) {
        System.out.println("-------param3-------");
        String username = request.getParameter("username");//通过参数名(url),获取参数值
        String age = request.getParameter("age");//通过参数名(url),获取参数值
        System.out.println("username="+username+" age="+age);
//        request.setAttribute("username",username);//将数据放入request
//        request.setAttribute("age",age);
        session.setAttribute("username",username);//将数据放入session
        session.setAttribute("age",age);//将数据放入session
        return "forward:/hello";//转发跳转
    }

    @RequestMapping(value = "/param4")
    public String param4(String username,int age) {
        System.out.println("-------param4-------");
        System.out.println("username="+username+" age="+age);
        return "hello";
    }
    @RequestMapping(value = "/param5")
    //@RequestParam(value = "对应参数名",required = 是否必填(t/f)默认为true,defaultValue = "默认值/缺损值")
    public String param5(@RequestParam(value = "username",required = false) String u, @RequestParam(value = "age",required = true,defaultValue = "20") int a) {//数据绑定
        System.out.println("-------param5-------");
        System.out.println("username="+u+" age="+a);
        return "hello";
    }
    @RequestMapping(value = "/param6")
    public String param6(HttpServletRequest request) {
        System.out.println("-------param6-------");
        System.out.println("username="+request.getParameter("username")+"age="+request.getParameter("age"));
        return "hello";
    }

    @RequestMapping(value = "/test1")
    public String test1() {
        System.out.println("-------test1-------");
        return "forward:/param1/test2";//跳转到控制器test2
    }
    @RequestMapping(value = "/test2")
    public String test2() {
        System.out.println("-------test2-------");
        return "hello";//跳转到视图：WEB-INF/pages/hello.jsp
    }
}
