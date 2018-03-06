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
import pl.mazurek.dm.dao.ahpdao.CriteriaRepository;
import pl.mazurek.dm.dao.entities.ahp.CriteriaAhp;
import pl.mazurek.dm.dao.util.DataBaseUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DecisionMakingApp.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CriteriaAhpRepositoryTest {

	@Autowired
	private DataBaseUtil dataBaseUtil;

	@Autowired
	private CriteriaRepository criteriaRepository;

	@Before
	public void setUp() {

		dataBaseUtil.createSampleData();
	}
	

	@Transactional
	@Test
	public void shouldGetAllCriterias() {

		long sizeOfCriteria = criteriaRepository.count();

		Assertions.assertThat(sizeOfCriteria).isGreaterThan(0);
	}

	@Transactional
	@Test
	public void shouldAddCriteriaSuccessfull() {

		CriteriaAhp criteriaEntity = dataBaseUtil.getCriteriaAhp(2);

		long sizeOfCriteriaBeforeAdd = criteriaRepository.count();
		
		CriteriaAhp savedCriteriaAhp = criteriaRepository.saveAndFlush(criteriaEntity);

		long sizeOfCriteria = criteriaRepository.count();

		Assertions.assertThat(sizeOfCriteria).isGreaterThan(sizeOfCriteriaBeforeAdd);
		Assertions.assertThat(savedCriteriaAhp.getName()).containsIgnoringCase("criteria");
	}

	@Transactional
	@Test
	public void shouldUpdateCriteriaSuccessfull() {

		CriteriaAhp criteriaEntity = criteriaRepository.findAll().stream().findFirst().get();

		criteriaEntity.setName("Kupno samochodu");

		CriteriaAhp savedCriteriaAhp = criteriaRepository.save(criteriaEntity);

		Assertions.assertThat(savedCriteriaAhp.getName()).containsIgnoringCase("kupno");
	}

	@Transactional
	@Test
	public void shouldDeleteCriteriaSuccessfull() {

		CriteriaAhp criteriaEntity = criteriaRepository.findAll().stream().findFirst().get();
		
		long sizeOfCriteriaBeforeDelete = criteriaRepository.count();
		
		criteriaRepository.delete(criteriaEntity);	

		long sizeOfCriteria = criteriaRepository.count();
		boolean stillExist = criteriaRepository.exists(criteriaEntity.getId());

		Assertions.assertThat(stillExist).isEqualTo(false);
		Assertions.assertThat(sizeOfCriteria).isLessThan(sizeOfCriteriaBeforeDelete);
	}
}
