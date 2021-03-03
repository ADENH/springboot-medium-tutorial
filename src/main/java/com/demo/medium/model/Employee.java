package com.demo.medium.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.demo.medium.dto.EmployeeDto;
import com.demo.medium.serviceimpl.GenderConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Integer id;
	
	@NotNull
	private String name;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date birthDate;
	
	@Column(unique = true)
	@NonNull
	private Integer idNumber;
	@NonNull
	private Integer gender;
	@NonNull
	private Integer isDelete;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
    private Position position;
	
	public Employee(EmployeeDto employeeDto) {
		this.name = employeeDto.getName();
		this.gender = employeeDto.getJenisKelamin() == GenderConverter.gender.PRIA ? 1 : 2;
		this.birthDate = employeeDto.getBirthDate();
		this.idNumber = employeeDto.getIdNumber();
		this.isDelete = 0;
	}
}
