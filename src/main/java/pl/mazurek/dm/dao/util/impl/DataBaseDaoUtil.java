package pl.mazurek.dm.dao.util.impl;

import java.util.Arrays;

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

@Repository
public class DataBaseDaoUtil implements DataBaseUtil {
	
	@Autowired
	private UserRepository userRepository;
	
	public void createSampleData() {
		
		GoalAhp goalAhp = getGoal1();
		
		ProjectEntity projectEntityAhp = getProject1();
		projectEntityAhp.setGoalAhp(goalAhp);
		
		UserEntity userEntityAdmin = getUser1();
		userEntityAdmin.setProjectEntities(Arrays.asList(projectEntityAhp));
		
		userRepository.saveAndFlush(userEntityAdmin);
	}

	private UserEntity getUser1() {
		UserEntity userEntityAdmin = new UserEntity();
		userEntityAdmin.setLogin("login1");
		userEntityAdmin.setPassword("password1");
		userEntityAdmin.setRole(Role.ADMIN);
		return userEntityAdmin;
	}

	private ProjectEntity getProject1() {
		ProjectEntity projectEntityAhp = new ProjectEntity();
		projectEntityAhp.setName("projekt1");
		projectEntityAhp.setAlgorithmType(AlgorithmType.AHP);
		return projectEntityAhp;
	}

	private GoalAhp getGoal1() {
		GoalAhp goalAhp = new GoalAhp();
		goalAhp.setName("goal1");
		return goalAhp;
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
	}
}
