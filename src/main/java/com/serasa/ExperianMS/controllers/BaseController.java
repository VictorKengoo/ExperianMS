package com.serasa.ExperianMS.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serasa.ExperianMS.models.Client;
import com.serasa.ExperianMS.response.ErrorResponse;
import com.serasa.ExperianMS.services.ClientService;
import com.serasa.ExperianMS.utils.ErrorUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BaseController {
	
    private final ClientService clientService;

    @GetMapping(path = "/clients")
    public ResponseEntity<ErrorResponse<List<Client>>> listAllClients(BindingResult result) {
		if(result.hasErrors()) {
			ErrorUtils<List<Client>> errorUtils = new ErrorUtils<>();
			return errorUtils.returnError(result.getAllErrors());
		}
        return ResponseEntity.ok(new ErrorResponse<List<Client>>(clientService.listAll()));
    }
    
    @GetMapping(path = "/client")
    public ResponseEntity<ErrorResponse<Optional<Client>>> listClientById(@PathVariable Long id, BindingResult result) {
		if(result.hasErrors()) {
			ErrorUtils<Optional<Client>> errorUtils = new ErrorUtils<>();
			return errorUtils.returnError(result.getAllErrors());
		}
        return ResponseEntity.ok(new ErrorResponse<Optional<Client>>(clientService.listById(id)));
    }
    
    @PostMapping(path = "/client")
    public ResponseEntity<ErrorResponse<Client>> createClient(@RequestBody @Valid Client client, BindingResult result) {
		if(result.hasErrors()) {
			ErrorUtils<Client> errorUtils = new ErrorUtils<>();
			return errorUtils.returnError(result.getAllErrors());
		}
        return new ResponseEntity<>(new ErrorResponse<Client>(clientService.insert(client)), HttpStatus.CREATED);
    }
}
