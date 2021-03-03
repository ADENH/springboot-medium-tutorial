package com.demo.medium;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.medium.serviceimpl.PositionServiceImpl;

@SpringBootTest
class MediumApplicationTests {
	
	@Autowired
	private PositionServiceImpl positionServiceImpl;

	@Test
	void getPositionByCodeNotFoundTest(){
		Assertions.assertThrows(NoSuchElementException.class, () ->{
			positionServiceImpl.getPositionByCode("not found");
		});
	}

}
