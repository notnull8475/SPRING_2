package ru.gb.SpringOne.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AppLogAspect {

    @Around("execution(public * ru.gb.SpringOne.services.AppUserService.*(..))")
    public Object beforeAnyMethodInAppUserService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("start service " + proceedingJoinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        log.info((MethodSignature) proceedingJoinPoint.getSignature() + " duration " + duration);
        return out;
    }

    @Around("execution(public * ru.gb.SpringOne.services.AppRoleService.*(..))")
    public Object beforeAnyMethodInAppRoleService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("start service " + proceedingJoinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        log.info((MethodSignature) proceedingJoinPoint.getSignature() + " duration " + duration);
        return out;
    }

    @Around("execution(public * ru.gb.SpringOne.services.ProductService.*(..))")
    public Object beforeAnyMethodInProductService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("start service " + proceedingJoinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        log.info((MethodSignature) proceedingJoinPoint.getSignature() + " duration " + duration);
        return out;
    }

}
