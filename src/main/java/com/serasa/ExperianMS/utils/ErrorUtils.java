package com.serasa.ExperianMS.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.serasa.ExperianMS.response.ErrorResponse;

public class ErrorUtils<T> {
	
	public ResponseEntity<ErrorResponse<T>> returnError(BindingResult result) {
		List<String> errors = new ArrayList<String>();
		result.getAllErrors().forEach(erro -> errors.add(erro.getDefaultMessage()));
		return ResponseEntity.badRequest().body(new ErrorResponse<T>(errors));
	}
	
}
