package pl.mazurek.dm.dao.impl;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import pl.mazurek.dm.dao.ahpdao.AlternativeRatingRepository;
import pl.mazurek.dm.dao.entities.ahp.AlternativRating;

public class AlternativRatingRepositoryImpl extends SimpleJpaRepository<AlternativRating, Long> implements AlternativeRatingRepository {

	EntityManager entityManager;
	
	public AlternativRatingRepositoryImpl(Class<AlternativRating> domainClass, EntityManager em) {
		super(domainClass, em);
		
		entityManager = em;
	}

}
