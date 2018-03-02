package pl.mazurek.dm.dao.util;

import pl.mazurek.dm.dao.entities.ahp.AlternativAhp;
import pl.mazurek.dm.dao.entities.ahp.AlternativRating;
import pl.mazurek.dm.dao.entities.ahp.CriteriaAhp;
import pl.mazurek.dm.dao.entities.ahp.CriteriaRating;
import pl.mazurek.dm.dao.entities.ahp.GoalAhp;
import pl.mazurek.dm.dao.entities.common.ProjectEntity;
import pl.mazurek.dm.dao.entities.common.UserEntity;

public interface DataBaseUtil {

	public void createSampleData();

	UserEntity getNewUser(int discriminator);

	ProjectEntity getNewProject(int discrimintor);

	GoalAhp getNewGoal(int discriminator);
	
	CriteriaAhp getCriteriaAhp(int discriminator);
	
	CriteriaRating getCriteriaRaing(Double rate);
	
	AlternativAhp getAlternativAhp(int discriminator);
	
	AlternativRating getAlternativRatig(Double rate);
}
