package com.demo.medium.dto;

import com.demo.medium.model.Position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(of = { "code", "name" })
public class PositionDto {
	private String code;
	private String name;
	
	public PositionDto(Position position) {
		this.code = position.getCode();
		this.name = position.getName();
	}
}
