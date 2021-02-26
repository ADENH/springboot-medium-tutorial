package com.demo.medium.config.aspect.target;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.demo.medium.dto.EmployeeDto;

@Aspect
@Component
public class EmployeeAspect {
	private static final Logger LOGGER = LogManager.getLogger(EmployeeAspect.class);
	
	@AfterReturning(value="execution(* com.demo.medium.serviceimpl.EmployeeServiceImpl.*(..))",returning="employee")  
	public void afterReturningAdvice(JoinPoint joinPoint, EmployeeDto employee)  
	{  
	LOGGER.info("After Returing method:"+joinPoint.getSignature());
	LOGGER.info(employee);
	}
}
