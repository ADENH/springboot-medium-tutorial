package com.demo.medium.config.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.demo.medium.model.entity.Position;
import com.demo.medium.repository.PositionRepository;

@Component
public class DemoData {
	@Autowired
	PositionRepository positionRepository;
	
	@EventListener
	public void appReady(ApplicationReadyEvent event) {
		
		Position position = new Position();
		position.setCode("PRGR");
		position.setName("Programmer");
		position.setIsDelete(0);
		positionRepository.save(position);
		
		Position position2 = new Position();
		position2.setCode("MNGR");
		position2.setName("Manager");
		position2.setIsDelete(0);
		positionRepository.save(position2);
		
		Position position3 = new Position();
		position3.setCode("string");
		position3.setName("string");
		position3.setIsDelete(0);
		positionRepository.save(position3);
		
	}
}
