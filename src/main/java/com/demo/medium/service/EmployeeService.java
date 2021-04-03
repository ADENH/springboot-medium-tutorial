package com.demo.medium.service;

import java.util.List;

import com.demo.medium.dto.EmployeeDto;


/**
 * Created by Spring Tool Suite.
 * @author Ade Hidayat
 * Telegram: adeenhaa
 * Date: Mar 18, 2021
 * Time: 11:56:15 AM
 */
public interface EmployeeService {
	/**
	 * @param id
	 * @return 
	 */
	EmployeeDto getEmployeeById(int id);
	
	/**
	 * @param idNumber
	 * @return
	 */
	EmployeeDto getEmployeeByIdNumber(int idNumber);
	
	/**
	 * @return
	 */
	List<EmployeeDto> getAllDataEmployee();
	
	/**
	 * @param idNumber
	 * @param employeeDto
	 * @return
	 */
	EmployeeDto updateDateEmployee(int idNumber,EmployeeDto employeeDto);
	
	/**
	 * @param idNumber
	 */
	void deleteDataEmployee(int idNumber);
	
	/**
	 * @param employeeDto
	 * @return
	 */
	EmployeeDto saveDateEmployee(EmployeeDto employeeDto);

}
