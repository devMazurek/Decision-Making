package pl.mazurek.dm.dao;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.mazurek.dm.DecisionMakingApp;
import pl.mazurek.dm.dao.ahpdao.GoalRepository;
import pl.mazurek.dm.dao.entities.ahp.GoalAhp;
import pl.mazurek.dm.dao.util.DataBaseUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DecisionMakingApp.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoalRepositoryTest {

	@Autowired
	private DataBaseUtil dataBaseUtil;

	@Autowired
	private GoalRepository goalAhpRepository;

	private final static int NUMBER_OF_GOALS = 1;

	@Before
	public void setUp() {

		dataBaseUtil.createSampleData();
	}
	

	@Transactional
	@Test
	public void shouldGetAllProjects() {

		long sizeOfGoals = goalAhpRepository.count();

		Assertions.assertThat(sizeOfGoals).isEqualTo(NUMBER_OF_GOALS);
	}

	@Transactional
	@Test
	public void shouldAddProjectSuccessfull() {

		GoalAhp goalEntiy = dataBaseUtil.getNewGoal(2);

		GoalAhp savedGoalAhp = goalAhpRepository.saveAndFlush(goalEntiy);

		long sizeOfGoals = goalAhpRepository.count();

		Assertions.assertThat(sizeOfGoals).isEqualTo(NUMBER_OF_GOALS + 1);
		Assertions.assertThat(savedGoalAhp.getName()).containsIgnoringCase("goal");
	}

	@Transactional
	@Test
	public void shouldUpdateProjectSuccessfull() {

		GoalAhp goalEntiy = goalAhpRepository.findAll().stream().findFirst().get();

		goalEntiy.setName("Kupno samochodu");

		GoalAhp savedGoalAhp = goalAhpRepository.save(goalEntiy);

		long sizeOfGoals = goalAhpRepository.count();

		Assertions.assertThat(sizeOfGoals).isEqualTo(NUMBER_OF_GOALS);
		Assertions.assertThat(savedGoalAhp.getName()).containsIgnoringCase("kupno");
	}

	@Transactional
	@Test
	public void shouldDeleteProjectSuccessfull() {

		GoalAhp goalEntiy = goalAhpRepository.findAll().stream().findFirst().get();
		
		goalAhpRepository.delete(goalEntiy);	

		long sizeOfGoals = goalAhpRepository.count();
		boolean stillExist = goalAhpRepository.exists(goalEntiy.getId());

		Assertions.assertThat(stillExist).isEqualTo(false);
		Assertions.assertThat(sizeOfGoals).isEqualTo(NUMBER_OF_GOALS - 1);
	}
}
