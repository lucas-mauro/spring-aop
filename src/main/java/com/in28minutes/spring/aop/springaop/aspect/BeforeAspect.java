package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class BeforeAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	@Before("execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))")
//	public void before(JoinPoint joinPoint) {
//		logger.info("Intercepted Method Calls - {}", joinPoint);
//	}
//	
//	@AfterReturning(
//			value = "execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))",
//			returning = "result")
//	public void after(JoinPoint joinPoint,Object result) {
//		logger.info("{} returned with value {}", joinPoint, result);
//	}
//	
//	@AfterThrowing(
//			value = "execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))",
//					throwing = "exception")
//	public void afterThrowing(JoinPoint joinPoint,Object exception) {
//		logger.info("{} returned with value {}", joinPoint, exception);
//	}
	
	@Around("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		
		joinPoint.proceed();
		
		long timeTaken = System.currentTimeMillis() - startTime; 
		logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
	}
	
}
