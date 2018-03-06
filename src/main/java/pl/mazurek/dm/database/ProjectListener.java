package pl.mazurek.dm.database;

import javax.persistence.PostPersist;

import pl.mazurek.dm.dao.entities.common.ProjectEntity;
import pl.mazurek.dm.database.util.DefaultEntitiesInserter;

public class ProjectListener {

	@PostPersist
	private void process(ProjectEntity projectEntity) {
		
		DefaultEntitiesInserter.insertDefaultGoal();
	}
}
