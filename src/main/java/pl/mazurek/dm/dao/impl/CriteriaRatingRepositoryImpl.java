package pl.mazurek.dm.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import pl.mazurek.dm.dao.ahpdao.CriteriaRatingRepository;
import pl.mazurek.dm.dao.entities.ahp.CriteriaRating;

public class CriteriaRatingRepositoryImpl extends SimpleJpaRepository<CriteriaRating, Long> implements CriteriaRatingRepository {

	EntityManager entityManager;
	
	public CriteriaRatingRepositoryImpl(Class<CriteriaRating> domainClass, EntityManager em) {
		super(domainClass, em);
		
		entityManager = em;
	}

}
