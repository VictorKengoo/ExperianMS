package com.serasa.ExperianMS.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.ObjectError;

import com.serasa.ExperianMS.models.Client;
import com.serasa.ExperianMS.response.ErrorResponse;

@ExtendWith(SpringExtension.class)
class ErrorUtilsTest {
	
	static ErrorUtils<Client> clientErrorUtils;
	static List<ObjectError> resultErrors;

	@BeforeAll
	public static void setUp() {
		clientErrorUtils = new ErrorUtils<Client>();
		resultErrors = createResultErrors();
	}

	private static List<ObjectError> createResultErrors() {
		List<ObjectError> resultErrors = new ArrayList<ObjectError>();
		
		ObjectError error1 = new ObjectError("Client", "Client Error 1");
		ObjectError error2 = new ObjectError("Client", "Client Error 2");
		ObjectError error3 = new ObjectError("Client", "Client Error 3");
		
		resultErrors.add(error1);
		resultErrors.add(error2);
		resultErrors.add(error3);
		
		return resultErrors;
	}

	@Test
	void returnErrorSuccess() {
		
		ResponseEntity<ErrorResponse<Client>> badRequestError = clientErrorUtils.returnError(resultErrors);
		
		assertEquals(400, badRequestError.getStatusCodeValue());
		assertEquals("Client Error 1", badRequestError.getBody().getErrors().get(0).toString());
		assertEquals("Client Error 2", badRequestError.getBody().getErrors().get(1).toString());
		assertEquals("Client Error 3", badRequestError.getBody().getErrors().get(2).toString());
	}

}
