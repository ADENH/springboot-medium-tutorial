package com.demo.medium.dto.response;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseTemplateHeader {

	private HttpStatus statusCode;
	private String responseType;
}
