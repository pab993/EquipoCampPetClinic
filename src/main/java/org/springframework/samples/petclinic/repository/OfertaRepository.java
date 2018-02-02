package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.Oferta;
import org.springframework.stereotype.Repository;

public interface OfertaRepository{
	
	Collection<Oferta> findAllNotExpired() throws DataAccessException;
	Oferta findById(int id) throws DataAccessException;
	Collection<Oferta> findAll() throws DataAccessException;
	void save(Oferta o) throws DataAccessException;
	void delete(Oferta o) throws DataAccessException;
		

}
