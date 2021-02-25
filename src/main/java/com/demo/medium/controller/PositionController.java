package com.demo.medium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.medium.dto.PositionDto;
import com.demo.medium.service.PositionService;

@RestController
@RequestMapping("/api/position")
public class PositionController {

	@Autowired
	PositionService positionService;
	
	@PostMapping
	ResponseEntity<?> savePosition(@RequestBody PositionDto positionDto){
		return new ResponseEntity<>(positionService.savePosition(positionDto), HttpStatus.CREATED);
	}
	
	@GetMapping
	ResponseEntity<?> getAllPositions(){
		return new ResponseEntity<>(positionService.getAllPositions(),HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	ResponseEntity<?> getPositionById(@PathVariable int id){
		return new ResponseEntity<>(positionService.getPositionById(id),HttpStatus.OK);
	}
	
	@GetMapping("/code/{code}")
	ResponseEntity<?> getPositionByCode(@PathVariable String code){
		return new ResponseEntity<>(positionService.getPositionByCode(code),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<?> updatePosition(@PathVariable int id,@RequestBody PositionDto positionDto){
		return new ResponseEntity<>(positionService.updatePosition(id, positionDto),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> deletePosition(@PathVariable int id){
		positionService.deletePosition(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
