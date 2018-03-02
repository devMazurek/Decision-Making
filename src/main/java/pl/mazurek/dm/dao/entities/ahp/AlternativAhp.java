package pl.mazurek.dm.dao.entities.ahp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import pl.mazurek.dm.dao.entities.AbstractDacisionMakingEntity;
import pl.mazurek.dm.dao.entities.AlternativEntity;

@Entity
public class AlternativAhp extends AbstractDacisionMakingEntity implements AlternativEntity{
	
	@ManyToOne
	private GoalAhp goalAhp;
	
	@OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<AlternativRating> alternativRatings;
	
	@ManyToOne
	private CriteriaAhp criteriaAhp;

	public GoalAhp getGoalAhp() {
		return goalAhp;
	}

	public void setGoalAhp(GoalAhp goalAhp) {
		this.goalAhp = goalAhp;
	}
	
	public List<AlternativRating> getAlternativRatings() {
		return alternativRatings;
	}

	public void setAlternativRatings(List<AlternativRating> alternativRatings) {
		this.alternativRatings = alternativRatings;
	}
}
