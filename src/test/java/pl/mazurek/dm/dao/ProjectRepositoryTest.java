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
import pl.mazurek.dm.dao.entities.common.ProjectEntity;
import pl.mazurek.dm.dao.util.DataBaseUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DecisionMakingApp.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectRepositoryTest {

	@Autowired
	private DataBaseUtil dataBaseUtil;

	@Autowired
	private ProjectRepository projectRepository;

	private final static int NUMBER_OF_PROJECTS = 1;

	@Before
	public void setUp() {

		dataBaseUtil.createSampleData();
	}
	

	@Transactional
	@Test
	public void shouldGetAllProjects() {

		long sizeOfProjects = projectRepository.count();

		Assertions.assertThat(sizeOfProjects).isEqualTo(NUMBER_OF_PROJECTS);
	}

	@Transactional
	@Test
	public void shouldAddProjectSuccessfull() {

		ProjectEntity projectEntity = dataBaseUtil.getNewProject(2);

		ProjectEntity savedProjectEntity = projectRepository.saveAndFlush(projectEntity);

		long sizeOfProjects = projectRepository.count();

		Assertions.assertThat(sizeOfProjects).isEqualTo(NUMBER_OF_PROJECTS + 1);
		Assertions.assertThat(savedProjectEntity.getName()).containsIgnoringCase("project");
	}

	@Transactional
	@Test
	public void shouldUpdateProjectSuccessfull() {

		ProjectEntity projectEntity = projectRepository.findAll().stream().findFirst().get();

		projectEntity.setName("Kupno samochodu");

		ProjectEntity savedProjectEntity = projectRepository.save(projectEntity);

		long sizeOfProjects = projectRepository.count();

		Assertions.assertThat(sizeOfProjects).isEqualTo(NUMBER_OF_PROJECTS);
		Assertions.assertThat(savedProjectEntity.getName()).containsIgnoringCase("kupno");
	}

	@Transactional
	@Test
	public void shouldDeleteProjectSuccessfull() {

		ProjectEntity projectEntity = projectRepository.findAll().stream().findFirst().get();
		
		projectRepository.delete(projectEntity);	

		long sizeOfProjects = projectRepository.count();
		boolean stillExist = projectRepository.exists(projectEntity.getId());

		Assertions.assertThat(stillExist).isEqualTo(false);
		Assertions.assertThat(sizeOfProjects).isEqualTo(NUMBER_OF_PROJECTS - 1);
	}
}
