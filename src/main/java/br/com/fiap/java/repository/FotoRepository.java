package br.com.fiap.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.java.model.Foto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer>{
	
	

}
