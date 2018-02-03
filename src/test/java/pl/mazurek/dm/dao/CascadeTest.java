package pl.mazurek.dm.dao;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pl.mazurek.dm.DecisionMakingApp;
import pl.mazurek.dm.dao.entities.common.ProjectEntity;
import pl.mazurek.dm.dao.entities.common.UserEntity;
import pl.mazurek.dm.dao.util.DataBaseUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DecisionMakingApp.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CascadeTest {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private DataBaseUtil dataBaseUtil;
	
	@Before
	public void setUp() {

		dataBaseUtil.createSampleData();
	}
	
	@Transactional
	@Test
	public void shoulAddProjectByUser(){
		
		UserEntity userEntity = userRepository.findAll().stream().findFirst().get();
		
		long countProjectsBefore = projectRepository.count();
		
		userEntity.getProjectEntities().add(dataBaseUtil.getNewProject(2));
		userRepository.saveAndFlush(userEntity);
		
		long countProjectsAfter = projectRepository.count();
		
		Assertions.assertThat(countProjectsAfter).isGreaterThan(countProjectsBefore);
	}
	
	@Transactional
	@Test
	public void shoulUpdateProjectByUser(){
		
		final String newName = "new name";
		UserEntity userEntity = userRepository.findAll().stream().findFirst().get();
		
		ProjectEntity projectEntity = userEntity.getProjectEntities().stream().findFirst().get();
		projectEntity.setName(newName);
		userRepository.saveAndFlush(userEntity);
	
		ProjectEntity projectEntityAfterChange = projectRepository.findAll().stream().findFirst().get();
		
		Assertions.assertThat(projectEntityAfterChange.getName()).isEqualTo(newName);
	}
	
	@Transactional
	@Test
	public void shoulDeleteChildrenProjects(){
		
		UserEntity userEntity = userRepository.findAll().stream().findFirst().get();
		
		long countProjectsBefore = projectRepository.count();
		
		userRepository.delete(userEntity);
		
		long countProjectsAfter = projectRepository.count();
		
		Assertions.assertThat(countProjectsAfter).isLessThan(countProjectsBefore);
	}
}
