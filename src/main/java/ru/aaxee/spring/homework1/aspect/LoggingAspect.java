package ru.aaxee.spring.homework1.aspect;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log
public class LoggingAspect {

    @Before("@annotation(ru.aaxee.spring.homework1.aspect.Log)")
    public void logBefore(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        log.info(signature.getDeclaringType().getSimpleName() + "#" + signature.getName());
    }
}
