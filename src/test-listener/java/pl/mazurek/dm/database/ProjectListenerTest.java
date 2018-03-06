package pl.mazurek.dm.database;

import org.assertj.core.api.Assertions;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.mazurek.dm.DecisionMakingApp;
import pl.mazurek.dm.dao.ProjectRepository;
import pl.mazurek.dm.dao.ahpdao.GoalRepository;
import pl.mazurek.dm.dao.util.DataBaseUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DecisionMakingApp.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectListenerTest {

	@Autowired
	private DataBaseUtil dataBaseUtil;

	@Autowired
	private GoalRepository goalAhpRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Transactional
	@Test
	public void shouldAddDefaultGoalByPostPersistProject() {
		
		projectRepository.save(dataBaseUtil.getNewProject(1));
		
		Assertions.assertThat(goalAhpRepository.findAll()).isNotEmpty();
	}
}
