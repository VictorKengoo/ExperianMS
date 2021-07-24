package com.serasa.ExperianMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serasa.ExperianMS.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
}
