package com.serasa.ExperianMS.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.serasa.ExperianMS.response.ErrorResponse;

public class ErrorUtils<T> {
	
	public ResponseEntity<ErrorResponse<T>> returnError(List<ObjectError> resultAllErrors) {
		List<String> errors = new ArrayList<String>();
		resultAllErrors.forEach(erro -> errors.add(erro.getDefaultMessage()));
		return ResponseEntity.badRequest().body(new ErrorResponse<T>(errors));
	}
	
}
