package br.com.fiap.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.java.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Integer>{
	
	

}
