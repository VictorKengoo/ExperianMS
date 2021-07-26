package com.serasa.ExperianMS.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ErrorResponse <T>{

	private T data;
	private List<String> errors;
	
	public ErrorResponse(T data) {
		this.data = data;
	}
	
	public ErrorResponse(List<String> errors) {
		this.errors = errors;
	}
}