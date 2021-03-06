package com.demo.medium.config.aspect.target;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.demo.medium.dto.PositionDto;

import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@Log4j2
public class PositionAspect {
//	private static final Logger LOGGER = LoggerFactory.getLogger(PositionAspect.class);
	
	@AfterReturning(value="execution(* com.demo.medium.serviceimpl.PositionServiceImpl.*(..))",returning="position")  
	public void afterReturningAdvice(JoinPoint joinPoint, PositionDto position)  
	{  
	log.info("After Returing method: "+joinPoint.getSignature());  
	log.info("{}", position);  // SLF4J, Log4j
	}
	
	
	@AfterReturning(value="execution(* com.demo.medium.serviceimpl.PositionServiceImpl.getAll*(..))",returning="position")  
	public void afterReturningAdvice(JoinPoint joinPoint, List<PositionDto> position)  
	{  
	log.info("After Returing method : {}",joinPoint.getSignature());
	log.info("{}", position);  // SLF4J, Log4j
	}
}
