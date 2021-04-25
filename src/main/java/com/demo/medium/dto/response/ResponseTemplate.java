package com.demo.medium.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseTemplate<T> extends ResponseBase{
	
	private T body;
}
