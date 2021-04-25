package com.demo.medium.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBase {

	private ResponseTemplateHeader header;
	private String message;
}
