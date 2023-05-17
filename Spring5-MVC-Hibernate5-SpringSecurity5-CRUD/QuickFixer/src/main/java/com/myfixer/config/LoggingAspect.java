package com.myfixer.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.example.controller.*.*(..))")
    public void loggableMethods() {}

    @AfterReturning(pointcut = "loggableMethods()", returning = "result")
    public void logMethodExecution(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String parameters = joinPoint.getArgs().toString();

        // Access the HttpServletRequest from the Aspect
        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session = request.getSession();

        // Access the user-id attribute from the session
        String userId = (String) session.getAttribute("user-id");

        // Perform the logging using log4j
        logger.info(String.format("[%s][%s][%s] %s", System.currentTimeMillis(), userId, methodName, parameters));
    }
}
