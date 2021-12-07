package edu.soft2.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class HellowordAspect {
    @Pointcut("execution(* edu.soft2.service..*.*(..))")
    public void myPointcut(){}

    @Before("myPointcut()")
    public void beforeAdvice(){
        System.out.println("——前置通知(先执行这里)——");
    }
    @After("myPointcut()")
    public void afterAdvice(){
        System.out.println("——后置通知(后执行这里)——");
    }


}
