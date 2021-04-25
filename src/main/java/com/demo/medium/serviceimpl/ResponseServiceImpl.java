package com.demo.medium.serviceimpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.demo.medium.dto.response.ResponseTemplate;
import com.demo.medium.dto.response.ResponseTemplateHeader;
import com.demo.medium.service.ResponseService;

@Service
public class ResponseServiceImpl implements ResponseService{

	@Override
	public <T> ResponseTemplate<T> apiSuccess(T data) {
		ResponseTemplateHeader header = new ResponseTemplateHeader();
		header.setStatusCode(HttpStatus.OK);
		header.setResponseType(MediaType.APPLICATION_JSON_VALUE);
		
		ResponseTemplate<T> response = new ResponseTemplate<>();
		response.setBody(data);
		response.setMessage("Success");
		response.setHeader(header);
		return response;
	}

}
