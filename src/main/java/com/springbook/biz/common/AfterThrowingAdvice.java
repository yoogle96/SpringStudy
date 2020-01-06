package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {


    @AfterThrowing(pointcut = "execution(* com.springbook.biz..*Impl.*(..))", throwing = "exceptionObj")
    public void exceptionLog(JoinPoint jp, Exception exceptionObj){
        String method = jp.getSignature().getName();
        System.out.println("[예외 처리] " + method + "() 메소드 수행 중 발생된 예외 메시지 : " + exceptionObj.getMessage());
    }
}
