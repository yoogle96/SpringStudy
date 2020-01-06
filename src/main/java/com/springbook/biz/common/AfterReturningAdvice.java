package com.springbook.biz.common;

import com.springbook.biz.user.UserVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturningAdvice {
//    @Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
//    public void getPointcut(){}

    @AfterReturning(pointcut = "execution(* com.springbook.biz..*Impl.get*(..))", returning = "returnObj")
    public void afterLog(JoinPoint jp, Object returnObj){

        String method = jp.getSignature().getName();
        if(returnObj instanceof UserVO){
            UserVO user = (UserVO) returnObj;
            if(user.getRole().equals("admin")){
                System.out.println(user.getName() + " 로그인(Admin)");
            }
        }

        System.out.println("[사후 처리]" + method + "() 메소드 리턴값 : " + returnObj.toString());
    }
}
