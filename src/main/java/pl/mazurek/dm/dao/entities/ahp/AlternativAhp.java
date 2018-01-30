package pl.mazurek.dm.dao.entities.ahp;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import pl.mazurek.dm.dao.entities.AbstractDacisionMakingEntity;
import pl.mazurek.dm.dao.entities.AlternativEntity;

@Entity
public class AlternativAhp extends AbstractDacisionMakingEntity implements AlternativEntity{
	
	@ManyToOne
	private GoalAhp goalAhp;

	public GoalAhp getGoalAhp() {
		return goalAhp;
	}

	public void setGoalAhp(GoalAhp goalAhp) {
		this.goalAhp = goalAhp;
	}
}
