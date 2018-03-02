package pl.mazurek.dm.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import pl.mazurek.dm.dao.ahpdao.CriteriaRepository;
import pl.mazurek.dm.dao.entities.ahp.CriteriaAhp;

public class CriteriaAhpRepositroyImpl extends SimpleJpaRepository<CriteriaAhp, Long> implements CriteriaRepository {

	EntityManager entityManager;
	
	public CriteriaAhpRepositroyImpl(Class<CriteriaAhp> domainClass, EntityManager em) {
		super(domainClass, em);
		
		entityManager = em;
	}

}
