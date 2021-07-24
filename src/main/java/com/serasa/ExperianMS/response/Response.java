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
public class Response <T>{

	private T data;
	private List<String> errors;
	
	public Response(T data) {
		this.data = data;
	}
	
	public Response(List<String> errors) {
		this.errors = errors;
	}
}