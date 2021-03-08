package com.demo.medium.config.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TokenResponse {
	private String token;
	private long expiredAt;
}
