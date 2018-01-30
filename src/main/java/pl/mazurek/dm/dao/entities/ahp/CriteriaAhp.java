package pl.mazurek.dm.dao.entities.ahp;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import pl.mazurek.dm.dao.entities.AbstractDacisionMakingEntity;
import pl.mazurek.dm.dao.entities.CriteriaEntity;

@Entity
public class CriteriaAhp extends AbstractDacisionMakingEntity implements CriteriaEntity{

	@ManyToOne
	private GoalAhp goalAhp;

	@OneToMany(mappedBy = "parent")
	private List<CriteriaRating> criteriaRatings;
	
	public GoalAhp getGoalAhp() {
		return goalAhp;
	}

	public void setGoalAhp(GoalAhp goalAhp) {
		this.goalAhp = goalAhp;
	}
}
