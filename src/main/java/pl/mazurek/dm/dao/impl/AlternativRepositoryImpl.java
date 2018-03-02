package pl.mazurek.dm.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import pl.mazurek.dm.dao.ahpdao.AlternativeRepository;
import pl.mazurek.dm.dao.entities.ahp.AlternativAhp;

public class AlternativRepositoryImpl extends SimpleJpaRepository<AlternativAhp, Long> implements AlternativeRepository {

	EntityManager entityManager;
	
	public AlternativRepositoryImpl(Class<AlternativAhp> domainClass, EntityManager em) {
		super(domainClass, em);
		
		entityManager = em;
	}

}
