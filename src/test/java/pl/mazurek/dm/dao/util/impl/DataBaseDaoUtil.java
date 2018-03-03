package pl.mazurek.dm.dao.util.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.mazurek.dm.common.AlgorithmType;
import pl.mazurek.dm.common.Role;
import pl.mazurek.dm.dao.ProjectRepository;
import pl.mazurek.dm.dao.UserRepository;
import pl.mazurek.dm.dao.ahpdao.AlternativeRatingRepository;
import pl.mazurek.dm.dao.ahpdao.AlternativeRepository;
import pl.mazurek.dm.dao.ahpdao.CriteriaRatingRepository;
import pl.mazurek.dm.dao.ahpdao.CriteriaRepository;
import pl.mazurek.dm.dao.ahpdao.GoalRepository;
import pl.mazurek.dm.dao.entities.ahp.AlternativAhp;
import pl.mazurek.dm.dao.entities.ahp.AlternativRating;
import pl.mazurek.dm.dao.entities.ahp.CriteriaAhp;
import pl.mazurek.dm.dao.entities.ahp.CriteriaRating;
import pl.mazurek.dm.dao.entities.ahp.GoalAhp;
import pl.mazurek.dm.dao.entities.common.ProjectEntity;
import pl.mazurek.dm.dao.entities.common.UserEntity;
import pl.mazurek.dm.dao.util.DataBaseUtil;

@Repository
public class DataBaseDaoUtil implements DataBaseUtil {

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
	private AlternativeRepository alternativeRepository;
	
	@Autowired
	private AlternativeRatingRepository alternativeRatingRepository;

	public void createSampleData() {

		AlternativRating alternativRating = getAlternativRatig(1d);
		
		AlternativAhp alternativAhp =  getAlternativAhp(1);
		List<AlternativRating> alternativRatings = new ArrayList<AlternativRating>();
		alternativRatings.add(alternativRating);
		alternativAhp.setAlternativRatings(alternativRatings);
		alternativRating.setParent(alternativAhp);
		
		AlternativAhp alternativAhp2 = getAlternativAhp(2);
		alternativRating.setComarable(alternativAhp2);
		List<AlternativRating> alternativRatingsListOfComparable = new ArrayList<AlternativRating>();
		alternativRatingsListOfComparable.add(alternativRating);
		alternativAhp2.setAlternativRatingsComparable(alternativRatingsListOfComparable);
		
		CriteriaRating criteriaRating = getCriteriaRaing(1d);
		
		CriteriaAhp criteriaAhp = getCriteriaAhp(1);
		List<CriteriaRating> criteriaRatings = new ArrayList<CriteriaRating>();
		criteriaRatings.add(criteriaRating);
		criteriaAhp.setCriteriaRatings(criteriaRatings);
		criteriaRating.setParent(criteriaAhp);
		List<AlternativRating> alternativRatingsList = new ArrayList<AlternativRating>();
		alternativRatingsList.add(alternativRating);
		criteriaAhp.setAlternativRatings(alternativRatingsList);
		alternativRating.setCriteriaAhp(criteriaAhp);
		
		CriteriaAhp criteriaAhp2 = getCriteriaAhp(2);
		criteriaRating.setComparable(criteriaAhp2);
		List<CriteriaRating> criteriaRatingList = new ArrayList<CriteriaRating>();
		criteriaRatingList.add(criteriaRating);
		criteriaAhp2.setCriteriaRatingsComparable(criteriaRatingList);
		
		GoalAhp goalAhp = getNewGoal(1);
		criteriaAhp.setGoalAhp(goalAhp);
		criteriaAhp2.setGoalAhp(goalAhp);
		List<CriteriaAhp> criteriaAhps = new ArrayList<CriteriaAhp>();
		criteriaAhps.add(criteriaAhp);
		criteriaAhps.add(criteriaAhp2);
		goalAhp.setCriteriaAhps(criteriaAhps);
		List<AlternativAhp> alternativAhps = new ArrayList<AlternativAhp>();
		alternativAhps.add(alternativAhp);
		alternativAhps.add(alternativAhp2);
		goalAhp.setAlternativAhps(alternativAhps);
		alternativAhp.setGoalAhp(goalAhp);
		alternativAhp2.setGoalAhp(goalAhp);
		
		ProjectEntity projectEntityAhp = getNewProject(1);
		projectEntityAhp.setGoalAhp(goalAhp);
		goalAhp.setProjectEntity(projectEntityAhp);
		
		UserEntity userEntityAdmin = getNewUser(1);
		List<ProjectEntity> projectEntities = new ArrayList<ProjectEntity>();
		projectEntities.add(projectEntityAhp);
		userEntityAdmin.setProjectEntities(projectEntities);
		projectEntityAhp.setUserEntity(userEntityAdmin);
		
		userRepository.save(userEntityAdmin);
		projectRepository.save(projectEntityAhp);
		goalRepository.save(goalAhp);
		criteriaRepository.save(criteriaAhp);
		criteriaRepository.save(criteriaAhp2);
		criteriaRatingRepository.save(criteriaRating);
		alternativeRepository.save(alternativAhp);
		alternativeRepository.save(alternativAhp2);
		alternativeRatingRepository.save(alternativRating);
	}

	public UserEntity getNewUser(int discriminator) {
		
		UserEntity userEntityAdmin = new UserEntity();
		userEntityAdmin.setLogin("login" + discriminator);
		userEntityAdmin.setPassword("password1");
		userEntityAdmin.setRole(Role.ADMIN);
		return userEntityAdmin;
	}

	public ProjectEntity getNewProject(int discrimintor) {
		
		ProjectEntity projectEntityAhp = new ProjectEntity();
		projectEntityAhp.setName("project" + discrimintor);
		projectEntityAhp.setAlgorithmType(AlgorithmType.AHP);
		return projectEntityAhp;
	}

	public GoalAhp getNewGoal(int discriminator) {
		
		GoalAhp goalAhp = new GoalAhp();
		goalAhp.setName("goal" + discriminator);
		return goalAhp;
	}

	public CriteriaAhp getCriteriaAhp(int discriminator) {

		CriteriaAhp criteriaAhp = new CriteriaAhp();
		criteriaAhp.setName("criteriaAhp" + discriminator);
		return criteriaAhp;
	}

	public CriteriaRating getCriteriaRaing(Double rate) {

		CriteriaRating criteriaRating = new CriteriaRating();
		criteriaRating.setRate(rate);
		return criteriaRating;
	}

	public AlternativAhp getAlternativAhp(int discriminator) {

		AlternativAhp alternativAhp = new AlternativAhp();
		alternativAhp.setName("alternativAhp" + discriminator);
		return alternativAhp;
	}

	public AlternativRating getAlternativRatig(Double rate) {
		
		AlternativRating alternativRating = new AlternativRating();
		alternativRating.setRate(rate);
		return alternativRating;
	}
}
