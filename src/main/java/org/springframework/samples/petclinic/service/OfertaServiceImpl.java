package org.springframework.samples.petclinic.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OfertaServiceImpl implements OfertaService{
	
	//Repository
	@Autowired
	private OfertaRepository ofertaRepository;
	
	
	//Services
	
	
	//Methods
	@Override
	public Collection<Oferta> findAll() {
		Collection<Oferta> ofertas = ofertaRepository.findAll();
		return ofertas;
	}

	@Override
	public Oferta findById(int id) {
		Oferta o = ofertaRepository.findById(id);
		return o;
	}

	@Override
	public Oferta save(Oferta o) {
		Oferta saved = ofertaRepository.save(o);
		return saved;
	}

	@Override
	public void deleteOferta(Oferta o) {
		// TODO Auto-generated method stub
		ofertaRepository.delete(o);
	}
	
	// Servicio que devuelve la lista de ofertas cuya fecha no ha expirado
	public Collection<Oferta> findAllNotExpired(){
		Collection<Oferta> ofertas = ofertaRepository.findAllNotExpired();
		return ofertas;
	}


}
