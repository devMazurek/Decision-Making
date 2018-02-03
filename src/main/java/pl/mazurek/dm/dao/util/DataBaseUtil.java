package pl.mazurek.dm.dao.util;

import pl.mazurek.dm.dao.entities.ahp.GoalAhp;
import pl.mazurek.dm.dao.entities.common.ProjectEntity;
import pl.mazurek.dm.dao.entities.common.UserEntity;

public interface DataBaseUtil {

	public void createSampleData();
	
	public void deleteAll();

	UserEntity getNewUser(int discriminator);

	ProjectEntity getNewProject(int discrimintor);

	GoalAhp getNewGoal(int discriminator);
}
