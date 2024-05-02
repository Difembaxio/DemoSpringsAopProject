package ru.difembaxio.springaspects.springsaopproject.aop.loging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

  /*
    @Pointcut("within(ru.difembaxio.springaspect.demospringaopproject.service.*)")
    public void productServiceMethod() {
    }
   */
  @Pointcut("execution(* service*(..) throws *)")
  public void productServiceMethod() {
  }

  @Before("productServiceMethod()")
  public void beforeProductServiceMethod() {
    log.info("==== BEFORE ====");
  }


  @After("productServiceMethod()")
  public void afterProductServiceMethod() {
    log.info("==== AFTER ====");
  }

  @AfterReturning("productServiceMethod()")
  public void afterReturningProductServiceMethod() {
    log.info("==== AFTER RETURNING ====");
  }

  @AfterThrowing("productServiceMethod()")
  public void afterThrowingProductServiceMethod() {
    log.info("==== AFTER Throwing ==== ");
  }

  @Around("productServiceMethod()")
  public Object aroundProductServiceMethod(ProceedingJoinPoint proceedingJoinPoint)
      throws Throwable {
    log.info("==== AROUND BEGIN ==== ");
    var result = proceedingJoinPoint.proceed();
    log.info("==== AROUND END ==== ");
    return result;
  }
}
