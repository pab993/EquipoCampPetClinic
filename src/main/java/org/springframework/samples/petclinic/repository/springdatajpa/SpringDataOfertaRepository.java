package org.springframework.samples.petclinic.repository.springdatajpa;

import java.util.Collection;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Oferta;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.OfertaRepository;
import org.springframework.samples.petclinic.repository.OwnerRepository;

@Profile("spring-data-jpa")
public interface SpringDataOfertaRepository extends OfertaRepository, Repository<Oferta, Integer>{

    @Override
    @Query("select o from Oferta o where o.fechaCad >= current_date()")
    public Collection<Oferta> findAllNotExpired();

    @Override
    @Query("SELECT o FROM Oferta o where o.id =:id")
    public Oferta findById(@Param("id") int id);
}
