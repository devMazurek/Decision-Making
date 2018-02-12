package pl.mazurek.dm.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import pl.mazurek.dm.dao.ProjectRepository;
import pl.mazurek.dm.dao.entities.common.ProjectEntity;

@Transactional
@Repository
public class ProjectRepositoryImpl extends SimpleJpaRepository<ProjectEntity, Long> implements ProjectRepository {

	EntityManager entityManager;
	
	public ProjectRepositoryImpl(Class<ProjectEntity> domainClass, EntityManager em) {
		
		super(domainClass, em);
		
		this.entityManager = em;
		// TODO Auto-generated constructor stub
	}

	public List<ProjectEntity> getProjectByName() {
		// TODO Auto-generated method stub
		return null;
	}

}
