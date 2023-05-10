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

    @After("execution(* com.esprit.demo.client.ClientServiceImpl.add*(..))")
    public void logMethodAfterClient(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @After("execution(* com.esprit.demo.composant.ComposantServiceImpl.add*(..))")
    public void logMethodComposant(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @After("execution(* com.esprit.demo.menu.MenuServiceImpl.add*(..))")
    public void logMethodAfterMenu(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @After("execution(* com.esprit.demo.restaurant.RestaurantServiceImpl.add*(..))")
    public void logMethodAfterRestaurant(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }


}
