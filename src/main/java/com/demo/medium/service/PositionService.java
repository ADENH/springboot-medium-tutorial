package com.demo.medium.service;

import java.util.List;

import com.demo.medium.dto.PositionDto;

public interface PositionService {
	List<PositionDto> getAllPositions();
	PositionDto getPositionByCode(String code);
	PositionDto getPositionById(int id);
	PositionDto savePosition(PositionDto positionDto);
	PositionDto updatePosition(int id,PositionDto positionDto);
	void deletePosition(int id);
}
