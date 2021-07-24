package com.serasa.ExperianMS.services;

import java.util.List;
import java.util.Optional;

import com.serasa.ExperianMS.models.Client;

public interface ClientService {
	Client insert(Client client);
	
	List<Client> listAll();
	
	Optional<Client> listById(Long id);
}
