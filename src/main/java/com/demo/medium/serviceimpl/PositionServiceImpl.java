package com.demo.medium.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.hibernate.UnresolvableObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.medium.config.ConstantUtil;
import com.demo.medium.config.aspect.Compliance;
import com.demo.medium.dto.PositionDto;
import com.demo.medium.model.ComplianceAction;
import com.demo.medium.model.Position;
import com.demo.medium.repository.PositionRepository;
import com.demo.medium.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	PositionRepository positionRepository;

	@Override
	@Compliance(action = ComplianceAction.read)
	public List<PositionDto> getAllPositions() {
		List<Position> allPositions = positionRepository.findByIsDelete(0);
		return new ArrayList<>(allPositions.stream()
				.map(position -> new PositionDto(position.getCode(), position.getName())).collect(Collectors.toList()));
	}

	@Override
	@Compliance(action = ComplianceAction.read)
	public PositionDto getPositionByCode(String code) {
		Position position = positionRepository.findByCode(code).orElseThrow(() -> new NoSuchElementException(ConstantUtil.DATA_TIDAK_DITEMUKAN));
		return new PositionDto(position);
	}

	@Override
	@Compliance(action = ComplianceAction.read)
	public PositionDto getPositionById(int id) {
		Position position = positionRepository.findById(id).orElseThrow(() -> new NoSuchElementException(ConstantUtil.DATA_TIDAK_DITEMUKAN));	
		return new PositionDto(position);
	}

	@Override
	@Compliance(action = ComplianceAction.create)
	public PositionDto savePosition(PositionDto positionDto) {
		Position position = new Position(positionDto);
		position = positionRepository.save(position);
		if (position.getId() == -1)
			throw new UnresolvableObjectException(Position.class, "Gagal Save Database");
		return positionDto;
	}

	@Override
	@Compliance(action = ComplianceAction.update)
	public PositionDto updatePosition(int id, PositionDto positionDto) {
		Position position = positionRepository.findById(id).orElseThrow(() -> new NoSuchElementException(ConstantUtil.DATA_TIDAK_DITEMUKAN));
		position.setCode(positionDto.getCode());
		position.setName(positionDto.getName());
		positionRepository.save(position);
		return new PositionDto(position);
	}

	@Override
	@Compliance(action = ComplianceAction.delete)
	public void deletePosition(int id) {
		Position position = positionRepository.findById(id).orElseThrow(() -> new NoSuchElementException(ConstantUtil.DATA_TIDAK_DITEMUKAN));
		position.setIsDelete(1);
		positionRepository.save(position);

	}

}
