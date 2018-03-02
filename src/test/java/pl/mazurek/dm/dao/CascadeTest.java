package pl.mazurek.dm.dao;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pl.mazurek.dm.DecisionMakingApp;
import pl.mazurek.dm.dao.ahpdao.AlternativeRatingRepository;
import pl.mazurek.dm.dao.ahpdao.AlternativeRepository;
import pl.mazurek.dm.dao.ahpdao.CriteriaRatingRepository;
import pl.mazurek.dm.dao.ahpdao.CriteriaRepository;
import pl.mazurek.dm.dao.ahpdao.GoalRepository;
import pl.mazurek.dm.dao.entities.ahp.CriteriaAhp;
import pl.mazurek.dm.dao.entities.ahp.GoalAhp;
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
	private GoalRepository goalRepository;
	
	@Autowired
	private CriteriaRepository criteriaRepository;
	
	@Autowired
	private CriteriaRatingRepository criteriaRatingRepository;
	
	@Autowired
	private AlternativeRepository alternativRepository;
	
	@Autowired
	private AlternativeRatingRepository AlternativeRatingRepository;
	
	@Autowired
	private DataBaseUtil dataBaseUtil;
	
	@Before
	public void setUp() {

		dataBaseUtil.createSampleData();
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
	public void shouldDeleteChildrenProjects(){
		
		UserEntity userEntity = userRepository.findAll().stream().findFirst().get();
		System.out.println(userEntity.getProjectEntities().size());
		long countProjectsBefore = projectRepository.count();
		
		userRepository.delete(userEntity);
		
		long countProjectsAfter = projectRepository.count();
		
		Assertions.assertThat(countProjectsAfter).isLessThan(countProjectsBefore);
	}
	
	@Transactional
	@Test
	public void shouldDeleteGoalByProject() {
		
		ProjectEntity projectEntity = projectRepository.findAll().stream().findFirst().get();
		
		long countBefore = goalRepository.count();

		projectRepository.delete(projectEntity);
		
		long countAfter = goalRepository.count();

		Assertions.assertThat(countAfter).isLessThan(countBefore);
	}
	
	@Transactional
	@Test
	public void shouldUpdateGoalByProject(){
		
		final String newName = "new name";
		ProjectEntity projectEntity = projectRepository.findAll().stream().findFirst().get();
		
		projectEntity.getGoalAhp().setName(newName);
		projectRepository.saveAndFlush(projectEntity);
		
		GoalAhp goalAhpEntityAfterChange = goalRepository.findAll().stream().findFirst().get();
		
		Assertions.assertThat(goalAhpEntityAfterChange.getName()).isEqualTo(newName);
	}
	
	@Transactional
	@Test
	public void shouldDeleteCriteriaByGoal() {
		
		GoalAhp goalEntity = goalRepository.findAll().stream().findFirst().get();
		
		long countBefore = criteriaRepository.count();

		goalRepository.delete(goalEntity);
		
		long countAfter = criteriaRepository.count();

		Assertions.assertThat(countAfter).isLessThan(countBefore);
	}
	
	@Transactional
	@Test
	public void shouldUpdateCriteriaByGoal(){
		
		final String newName = "new name";
		GoalAhp goalEntity = goalRepository.findAll().stream().findFirst().get();
		
		goalEntity.getCriteriaAhps().stream().findFirst().get().setName(newName);
		goalRepository.saveAndFlush(goalEntity);
		
		CriteriaAhp criteriaEntityAfterChange = criteriaRepository.findAll().stream()
				.filter(c -> c.getName().equals(newName)).findFirst().get();
		
		Assertions.assertThat(criteriaEntityAfterChange).isNotNull();
	}
	
	
}