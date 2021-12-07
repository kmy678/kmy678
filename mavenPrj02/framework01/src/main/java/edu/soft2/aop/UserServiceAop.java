package edu.soft2.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class UserServiceAop {
    @Pointcut("execution(* edu.soft2.service..*.*(..))")
    public void pointA(){

    }
    @Before("pointA()")
    public void beforeA(){
        System.out.println("前置增强！！！");
    }
    @After("pointA()")
    public void afterA(){
        System.out.println("后置增强！！！");
    }
}
