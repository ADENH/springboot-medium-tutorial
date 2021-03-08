package com.demo.medium.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto extends EmployeeDto {
	private String username;
	private String email;
	private String password;
	private String fullname;
}
