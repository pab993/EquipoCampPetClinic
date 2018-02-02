package org.springframework.samples.petclinic.service;

import java.util.Collection;

public interface OfertaService {

	Collection<Oferta> findAll();
	
	Oferta findById(int id);
	
	void delete deleteOferta(Oferta o);
	
	Oferta save(Oferta o);
	
	Collection<Oferta> findAllNotExpired();
	
}
