package com.serasa.ExperianMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serasa.ExperianMS.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
}
