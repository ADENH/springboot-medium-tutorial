package com.demo.medium.config.security.model;

import lombok.Data;

@Data
public class UsernamePasswordRequest {
	private String username;
	private String password;
}
