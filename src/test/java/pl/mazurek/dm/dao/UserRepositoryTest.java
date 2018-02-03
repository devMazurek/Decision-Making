package pl.mazurek.dm.dao;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

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
import pl.mazurek.dm.dao.entities.common.UserEntity;
import pl.mazurek.dm.dao.util.DataBaseUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DecisionMakingApp.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserRepositoryTest {
	@Autowired
	private DataBaseUtil dataBaseUtil;

	@Autowired
	private UserRepository userRepository;

	private final static int NUMBER_OF_USERS = 1;

	@Before
	public void setUp() {

		dataBaseUtil.createSampleData();
	}

	@Transactional
	@Test
	public void shouldGetAllUsers() {

		long sizeOfUsers = userRepository.count();

		Assertions.assertThat(sizeOfUsers).isEqualTo(NUMBER_OF_USERS);
	}

	@Transactional
	@Test
	public void shouldAddUserSuccessfull() {

		UserEntity userEntity = getNewUser(2);

		UserEntity savedUserEntity = userRepository.saveAndFlush(userEntity);

		long sizeOfUsers = userRepository.count();

		Assertions.assertThat(sizeOfUsers).isEqualTo(NUMBER_OF_USERS + 1);
		Assertions.assertThat(savedUserEntity.getLogin()).containsIgnoringCase("user");
	}

	@Transactional
	@Test
	public void shouldUpdateUserSuccessfull() {

		UserEntity userEntity = userRepository.findAll().stream().findFirst().get();

		userEntity.setLogin("nowy");

		UserEntity savedUserEntity = userRepository.saveAndFlush(userEntity);

		long sizeOfUsers = userRepository.count();

		Assertions.assertThat(sizeOfUsers).isEqualTo(NUMBER_OF_USERS);
		Assertions.assertThat(savedUserEntity.getLogin()).containsIgnoringCase("nowy");
	}

	@Transactional(value = TxType.SUPPORTS)
	@Test
	public void shouldDeleteUserSuccessfull() {

		UserEntity userEntity = userRepository.findAll().stream().findFirst().get();

		userRepository.delete(userEntity);

		long sizeOfUsers = userRepository.count();
		boolean stillExist = userRepository.exists(userEntity.getId());

		Assertions.assertThat(stillExist).isEqualTo(false);
		Assertions.assertThat(sizeOfUsers).isEqualTo(NUMBER_OF_USERS - 1);
	}

	private UserEntity getNewUser(int numberOfUser) {

		UserEntity userEntity = new UserEntity();
		userEntity.setLogin("User" + numberOfUser);

		return userEntity;
	}
}
