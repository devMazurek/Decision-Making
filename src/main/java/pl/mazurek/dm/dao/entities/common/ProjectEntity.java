package pl.mazurek.dm.dao.entities.common;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import pl.mazurek.dm.common.AlgorithmType;
import pl.mazurek.dm.dao.entities.AbstractDacisionMakingEntity;
import pl.mazurek.dm.dao.entities.ahp.GoalAhp;
import pl.mazurek.dm.database.ProjectListener;

@Entity
@EntityListeners(ProjectListener.class)
public class ProjectEntity extends AbstractDacisionMakingEntity {

	
	@ManyToOne
	private UserEntity userEntity;
	
	@Column
	@Enumerated(EnumType.STRING)
	private AlgorithmType algorithmType;

	@OneToOne(mappedBy = "projectEntity", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private GoalAhp goalAhp;
	
	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public AlgorithmType getAlgorithmType() {
		return algorithmType;
	}

	public void setAlgorithmType(AlgorithmType algorithmType) {
		this.algorithmType = algorithmType;
	}

	public GoalAhp getGoalAhp() {
		return goalAhp;
	}

	public void setGoalAhp(GoalAhp goalAhp) {
		this.goalAhp = goalAhp;
	}

}
