package com.demo.medium.service;

import com.demo.medium.dto.response.ResponseTemplate;

public interface ResponseService {

	<T> ResponseTemplate<T> apiSuccess(T data);
}
