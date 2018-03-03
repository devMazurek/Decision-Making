package pl.mazurek.dm.util;

import org.springframework.beans.factory.annotation.Autowired;

import pl.mazurek.dm.dao.ProjectRepository;
import pl.mazurek.dm.dao.ahpdao.GoalRepository;
import pl.mazurek.dm.dao.entities.ahp.GoalAhp;
import pl.mazurek.dm.dao.entities.common.ProjectEntity;

public class DefaultEntitiesInserter {

	@Autowired
	private static GoalRepository goalRepository;
	
	public static ProjectEntity insertDefaultGoal() {
		
		return goalRepository.save(getDefaultGoal());
	}
	
	private static GoalAhp getDefaultGoal() {
		
		return null;
	}
}
