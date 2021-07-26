package com.serasa.ExperianMS.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.ExperianMS.models.Client;
import com.serasa.ExperianMS.repository.ClientRepository;
import com.serasa.ExperianMS.services.ClientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {	
	
	private final ClientRepository clientRepository;

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
