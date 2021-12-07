package edu.soft2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAop {
    //1.设置切入点
    @Pointcut("execution(* edu.soft2.service..*.*(..))") //设置切入点的拦截范围
    public void pointA() {}
    //2.设置前置增强
    @Before("pointA()")
    public void beforeA(){
            System.out.println("前置增强！！！");
        }
    //3.设置后置增强
    @After("pointA()")
    public void afterA(){
            System.out.println("后置增强！！！");
    }
    //4.环绕增强
    @Around("pointA()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object res = null;
        System.out.println("准备执行目标对象"+pjp.getTarget()+"的"+pjp.getSignature().getName()+"()方法");//环绕增强的前环绕
        res = pjp.proceed();//执行aop代理链方法
        System.out.println("已经执行目标对象"+pjp.getTarget()+"的"+pjp.getSignature().getName()+"()方法");//环绕增强的后环绕
        return res;
    }
    @AfterReturning(value = "pointA()",returning = "result")
    public void afterRe(JoinPoint jp, Object result){

        System.out.println("执行完毕"+jp.getTarget()+"的"+jp.getSignature().getName()+"()方法，返回值为"+result);
    }
}
