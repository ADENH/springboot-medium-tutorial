package com.demo.medium.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.demo.medium.model.entity.Employee;
import com.demo.medium.serviceimpl.GenderConverter;
import com.demo.medium.serviceimpl.GenderConverter.gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private String name;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date birthDate;
	private Integer idNumber;
	private gender jenisKelamin;
	private String codeJabatan;
	
	public EmployeeDto(Employee employee){
		this.name= employee.getName();
		this.birthDate = employee.getBirthDate();
		this.idNumber = employee.getIdNumber();
		this.jenisKelamin = GenderConverter.convert(employee.getGender()) ;
		this.codeJabatan = employee.getPosition().getCode();
	}
	
}
