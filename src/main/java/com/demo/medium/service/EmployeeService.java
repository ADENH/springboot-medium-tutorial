package com.demo.medium.service;

import java.util.List;

import com.demo.medium.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto getEmployeeById(int id);
	EmployeeDto getEmployeeByIdNumber(int idNumber);
	List<EmployeeDto> getAllDataEmployee();
	EmployeeDto updateDateEmployee(int idNumber,EmployeeDto employeeDto);
	void deleteDataEmployee(int idNumber);
	EmployeeDto saveDateEmployee(EmployeeDto employeeDto);

}
