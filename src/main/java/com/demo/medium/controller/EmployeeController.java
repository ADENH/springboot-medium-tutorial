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

import com.demo.medium.dto.EmployeeDto;
import com.demo.medium.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<?> getAllEmployeeData(){
		return new ResponseEntity<>(employeeService.getAllDataEmployee(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> saveDataEmployee(@RequestBody EmployeeDto employeeDto) {
		employeeService.saveDateEmployee(employeeDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{idNumber}")
	public ResponseEntity<?> getEmployeeDataByIdNumber(@PathVariable int idNumber){
		return new ResponseEntity<>(employeeService.getEmployeeByIdNumber(idNumber),HttpStatus.OK);
	}
	
	@PutMapping("/{idNumber}")
	public ResponseEntity<?> updateDataEmployee(@PathVariable int idNumber,@RequestBody EmployeeDto employeeDto){
		return new ResponseEntity<>(employeeService.updateDateEmployee(idNumber, employeeDto), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{idNumber}")
	public ResponseEntity<?> deleteDataEmployee(@PathVariable int idNumber){
		employeeService.deleteDataEmployee(idNumber);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
