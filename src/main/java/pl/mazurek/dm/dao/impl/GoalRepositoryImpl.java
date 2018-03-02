package pl.mazurek.dm.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

import pl.mazurek.dm.dao.ahpdao.GoalRepository;
import pl.mazurek.dm.dao.entities.ahp.GoalAhp;

public class GoalRepositoryImpl extends SimpleJpaRepository<GoalAhp, Long> implements GoalRepository {

	private EntityManager entityManager;
	
	public GoalRepositoryImpl(Class<GoalAhp> domainClass, EntityManager em) {
		
		super(domainClass, em);
		
		this.entityManager = em;
		
	}

}
