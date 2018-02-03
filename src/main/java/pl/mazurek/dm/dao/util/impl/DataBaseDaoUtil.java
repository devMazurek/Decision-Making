package pl.mazurek.dm.dao.util.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.mazurek.dm.common.AlgorithmType;
import pl.mazurek.dm.common.Role;
import pl.mazurek.dm.dao.ProjectRepository;
import pl.mazurek.dm.dao.UserRepository;
import pl.mazurek.dm.dao.entities.ahp.GoalAhp;
import pl.mazurek.dm.dao.entities.common.ProjectEntity;
import pl.mazurek.dm.dao.entities.common.UserEntity;
import pl.mazurek.dm.dao.util.DataBaseUtil;

@Transactional
@Repository
public class DataBaseDaoUtil implements DataBaseUtil {
	
	@Autowired
	private UserRepository userRepository;
	
	public void createSampleData() {
		
		GoalAhp goalAhp = getNewGoal(1);
		
		ProjectEntity projectEntityAhp = getNewProject(1);
		projectEntityAhp.setGoalAhp(goalAhp);
		
		UserEntity userEntityAdmin = getNewUser(1);
		projectEntityAhp.setUserEntity(userEntityAdmin);
		List<ProjectEntity> projectEntities = new ArrayList<ProjectEntity>();
		projectEntities.add(projectEntityAhp);
		userEntityAdmin.setProjectEntities(projectEntities);
		
		
		
		userRepository.saveAndFlush(userEntityAdmin);
	}

	public UserEntity getNewUser(int discriminator) {
		UserEntity userEntityAdmin = new UserEntity();
		userEntityAdmin.setLogin("login" + discriminator);
		userEntityAdmin.setPassword("password1");
		userEntityAdmin.setRole(Role.ADMIN);
		return userEntityAdmin;
	}

	public ProjectEntity getNewProject(int discrimintor) {
		ProjectEntity projectEntityAhp = new ProjectEntity();
		projectEntityAhp.setName("projekt" + discrimintor);
		projectEntityAhp.setAlgorithmType(AlgorithmType.AHP);
		return projectEntityAhp;
	}

	public GoalAhp getNewGoal(int discriminator) {
		GoalAhp goalAhp = new GoalAhp();
		goalAhp.setName("goal" + discriminator);
		return goalAhp;
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
	}
}
