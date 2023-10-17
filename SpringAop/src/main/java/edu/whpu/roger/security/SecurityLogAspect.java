package edu.whpu.roger.security;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class SecurityLogAspect {

    @Before("execution(* edu.whpu.roger.security.UserService.*(..)) || execution(* edu.whpu.roger.security.VipService.*(..))")
    public void logSecurityInfo(JoinPoint joinPoint) {
        // 获取当前系统时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(new Date());

        // 获取操作人员的信息（模拟硬编码）
        String operatorName = "hanxue";

        // 获取目标方法的详细信息
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        // 输出日志信息
        System.out.println(currentTime + " - 操作人员: " + operatorName);
        System.out.println("调用方法: " + className + "." + methodName);
    }
}
