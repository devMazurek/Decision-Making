package pl.mazurek.database;

import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.mazurek.dm.dao.ahpdao.GoalRepository;
import pl.mazurek.dm.dao.entities.common.ProjectEntity;
import pl.mazurek.dm.util.DefaultEntitiesInserter;

@Component
public class ProjectInsertListener implements PostInsertEventListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	public void onPostInsert(PostInsertEvent event) {
		
		if(event.getEntity() instanceof ProjectEntity) {
			
			DefaultEntitiesInserter.insertDefaultGoal();
		}
		
	}

	@Override
	public boolean requiresPostCommitHanding(EntityPersister persister) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
