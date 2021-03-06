package br.com.fiap.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.java.model.Foto;


/**
 * @author Ali Moussa Chouman
 * @since 24 Sep 2020
 */

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer>{
	
	

}
