package exceptionDemo.controller;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class AspectDemo {
	
	private static Logger logger = Logger.getLogger(AspectDemo.class);
	
	@Pointcut("execution(* *.*(..))")
	public void pointcutName(){
		
	}
	@AfterThrowing(pointcut="pointcutName()", throwing="e")
	public void wirteLog(Exception e){
		logger.debug("==================================");
		logger.debug(e);
	}
	
	@Before("pointcutName()")
	public void writeBefore(){
		logger.debug("===================writeBefore===============");
	}
	
	
}
