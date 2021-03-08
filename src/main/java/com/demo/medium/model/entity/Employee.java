package com.demo.medium.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.demo.medium.dto.AccountDto;
import com.demo.medium.dto.EmployeeDto;
import com.demo.medium.serviceimpl.GenderConverter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7865569240793115769L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	private Integer id;
	
	@NonNull
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
	
	@NotNull
	@Column(unique = true)
	private String username;

	@NotNull
	private String fullName;

	@NotNull
	private String password;

	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	@JoinColumn(name = "position_id")
    private Position position;
	
	public Employee(EmployeeDto employeeDto) {
		this.id = -1;
		this.name = employeeDto.getName();
		this.gender = employeeDto.getJenisKelamin() == GenderConverter.gender.PRIA ? 1 : 2;
		this.birthDate = employeeDto.getBirthDate();
		this.idNumber = employeeDto.getIdNumber();
		this.isDelete = 0;

	}
	
	public Employee(AccountDto account) {
		this.id = -1;
		this.name = account.getName();
		this.gender = account.getJenisKelamin() == GenderConverter.gender.PRIA ? 1 : 2;
		this.birthDate = account.getBirthDate();
		this.idNumber = account.getIdNumber();
		this.isDelete = 0;
		
		this.email = account.getEmail();
		this.fullName = account.getFullname();
		this.password = account.getPassword();
		this.username = account.getUsername();
	}
}
