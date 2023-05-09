package com.esprit.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogingAspect {

    /**
     * “?” veut dire optionnel
     * Modifiers-pattern? : public, private ...
     * Ret-type-pattern : le type de retour.
     * Declaring-type-pattern? : nom de la classe y compris le package.
     * Name-pattern : nom de la méthode.
     * Throws-pattern? : l’exception.
     * “..” veut dire, 0 ou plusieurs paramètres
     */

    @Before("execution(* com.esprit.demo.*.add*(..))")

    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @AfterReturning("execution(* com.esprit.demo.*.add*(..))")
    public void logMethodAfterReturning(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @AfterThrowing("execution(* com.esprit.demo.*.add*(..))")
    public void logMethodAfterThrowing(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @After("execution(* com.esprit.demo.*.add*(..))")
    public void logMethodAfter(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @Around("execution(* com.esprit.demo.*.add*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }

}
