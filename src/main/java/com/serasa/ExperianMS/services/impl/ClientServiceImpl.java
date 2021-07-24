package com.serasa.ExperianMS.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.serasa.ExperianMS.models.Client;
import com.serasa.ExperianMS.repository.ClientRepository;
import com.serasa.ExperianMS.services.ClientService;

public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client insert(Client client) {
		this.clientRepository.save(client);
		return client;
	}

	@Override
	public List<Client> listAll() {
		return this.clientRepository.findAll();
	}

	@Override
	public Optional<Client> listById(Long id) {
		return this.clientRepository.findById(id);
	}

}
