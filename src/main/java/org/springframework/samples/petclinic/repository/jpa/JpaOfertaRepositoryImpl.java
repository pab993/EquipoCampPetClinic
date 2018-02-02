package org.springframework.samples.petclinic.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Oferta;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.repository.OfertaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("jpa")
public class JpaOfertaRepositoryImpl implements OfertaRepository{

	   @PersistenceContext
	    private EntityManager em;

	   
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Oferta> findAllNotExpired() {
		// TODO Auto-generated method stub
		return this.em.createQuery("select o from Oferta o where o.fechaCad >= current_date()").getResultList();

	}

//	@Override
//	public Oferta findById(int id) {
//		Query query = this.em.createQuery("SELECT o FROM Oferta o where o.id =:id");
//        query.setParameter("id", id);
//        return (Oferta) query.getSingleResult();
//	}
	
    @Override
    public Oferta findById(int id) {
        return this.em.find(Oferta.class, id);
    }

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Oferta> findAll() throws DataAccessException{
		return this.em.createQuery("SELECT oferta FROM Oferta oferta").getResultList();
	}

	@Override
	public void save(Oferta o) throws DataAccessException{
        if (o.getId() == null) {
            this.em.persist(o);
        } else {
            this.em.merge(o);
        }
	}

	@Override
	public void delete(Oferta o) throws DataAccessException{
		// TODO Auto-generated method stub
		this.em.remove(this.em.contains(o) ? o : this.em.merge(o));
	}

}
