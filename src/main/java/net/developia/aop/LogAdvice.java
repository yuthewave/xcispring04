package net.developia.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {

	@Before("execution(* net.developia.service.SampleService*.*(..))")
	public void logBefore() {
		
		log.info("=================");
		log.info("= before advice =");
		log.info("=================");
	}
	
	@Before("execution(* net.developia.service.SampleService*.doAdd(String,String)) && args(str1, str2)")
	public void logBeforeWithParam(String str1, String str2) {
		
		log.info("str1: " + str1);
		log.info("str2: " + str2);
	}
	
	@AfterThrowing(pointcut = "execution(* net.developia.service.SampleService*.*(..))", throwing="exception")
	public void logException(Exception exception) {
		
		log.info("Exception....!!!!");
		log.info("Exception: " + exception);
		
	}
	
	@Around("execution(* net.developia.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		
		long start = System.currentTimeMillis();
		
		log.info("Target: " + pjp.getTarget());
		log.info("Param: " + Arrays.toString(pjp.getArgs()));
		
		//invoke method
		Object result = null;
		
		try {
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		log.info("Time: " + (end - start));
		
		return result;
	}
}
