package com.proj.demo.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//    @Before("execution(* com.proj.demo.service.JobService.*(..))")    //for all methods
    @Before("execution(* com.proj.demo.service.JobService.getJob(..))")    //for updateJob methode only
    public void logMethodeCall(JoinPoint jp){
        LOGGER.info("Methode called" + jp.getSignature().getName());
    }

    @After("execution(* com.proj.demo.service.JobService.getJob(..))")    //for updateJob methode only
    public void logMethodeExecuted(JoinPoint jp){
        LOGGER.info("Methode Executed " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.proj.demo.service.JobService.getJob(..))")    //for updateJob methode only
    public void logMethodeCrash(JoinPoint jp){
        LOGGER.info("Methode has some issues  " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.proj.demo.service.JobService.getJob(..))")    //for updateJob methode only
    public void logMethodeExecutedSuccesfully(JoinPoint jp){
        LOGGER.info("Methode Executed successfully  " + jp.getSignature().getName());
    }
}
