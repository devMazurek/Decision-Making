package pl.mazurek.dm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.mazurek.dm.dao.entities.common.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	public UserEntity getUserByLogin(String login);
}
