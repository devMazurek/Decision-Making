package pl.mazurek.dm.database.util;

import pl.mazurek.dm.SpringApplicationContext;
import pl.mazurek.dm.dao.ahpdao.GoalRepository;
import pl.mazurek.dm.dao.entities.ahp.GoalAhp;

public class DefaultEntitiesInserter {
	
	public static GoalAhp insertDefaultGoal() {
		
		GoalRepository goalRepository = SpringApplicationContext.getBean(GoalRepository.class);
		
		if(goalRepository != null) {
			
			return goalRepository.save(getDefaultGoal());
		}
		
		return null;
	}
	
	private static GoalAhp getDefaultGoal() {
		
		GoalAhp goalAhp = new GoalAhp();
		goalAhp.setName("Default goal");
		
		return goalAhp;
	}
}
