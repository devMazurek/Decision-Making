package pl.mazurek.dm.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import pl.mazurek.dm.dao.UserRepository;
import pl.mazurek.dm.dao.entities.common.UserEntity;

@Repository
public class UserRepositoryImpl extends SimpleJpaRepository<UserEntity, Long> implements UserRepository{

	private EntityManager entityManager;

	public UserRepositoryImpl(Class<UserEntity> domainClass, EntityManager em) {
		
		super(domainClass, em);
		this.entityManager = em;
	}

	public UserEntity getUserByLogin(String login) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserEntity>  criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
		
		Root<UserEntity> user = criteriaQuery.from(UserEntity.class);
		criteriaQuery.select(user).where(criteriaBuilder.equal(user.get("id"), login));
		
		TypedQuery<UserEntity> typedQuery = entityManager.createQuery(criteriaQuery);
		
		return typedQuery.getSingleResult();
	}
	
	
}
