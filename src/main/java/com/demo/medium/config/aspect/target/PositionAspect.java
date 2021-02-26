package com.demo.medium.config.aspect.target;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.demo.medium.dto.PositionDto;

@Aspect
@Component
public class PositionAspect {
private static final Logger LOGGER = LogManager.getLogger(PositionAspect.class);
	
	@AfterReturning(value="execution(* com.demo.medium.serviceimpl.PositionServiceImpl.*(..))",returning="position")  
	public void afterReturningAdvice(JoinPoint joinPoint, PositionDto position)  
	{  
	LOGGER.info("After Returing method:"+joinPoint.getSignature());  
	LOGGER.info(position);  
	}  
}
