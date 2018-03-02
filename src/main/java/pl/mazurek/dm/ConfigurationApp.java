package pl.mazurek.dm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.mazurek.dm.dao.entities.ahp.AlternativAhp;
import pl.mazurek.dm.dao.entities.ahp.AlternativRating;
import pl.mazurek.dm.dao.entities.ahp.CriteriaAhp;
import pl.mazurek.dm.dao.entities.ahp.CriteriaRating;
import pl.mazurek.dm.dao.entities.ahp.GoalAhp;
import pl.mazurek.dm.dao.entities.common.ProjectEntity;
import pl.mazurek.dm.dao.entities.common.UserEntity;

@Configuration
@ComponentScan("pl.mazurek.dm")
public class ConfigurationApp {
	
	@Bean
	public Class<ProjectEntity> projectEntityClass() {
		return ProjectEntity.class;
	}
	
	@Bean
	public Class<UserEntity> userEntityClass() {
		return UserEntity.class;
	}
	
	@Bean
	public Class<GoalAhp> goalEntityClass() {
		return GoalAhp.class;
	}
	
	@Bean
	public Class<CriteriaRating> criteriaRatingEntityClass() {
		return CriteriaRating.class;
	}
	
	@Bean
	public Class<AlternativAhp> alternativEntityClass() {
		return AlternativAhp.class;
	}
	
	@Bean
	public Class<AlternativRating> alternativRatingEntityClass() {
		return AlternativRating.class;
	}
}
