package pl.mazurek.dm.dao.entities.ahp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import pl.mazurek.dm.dao.entities.AbstractDacisionMakingEntity;
import pl.mazurek.dm.dao.entities.CriteriaEntity;

@Entity
public class CriteriaAhp extends AbstractDacisionMakingEntity implements CriteriaEntity{

	@ManyToOne
	private GoalAhp goalAhp;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<CriteriaRating> criteriaRatings;
	
	@OneToMany(mappedBy = "criteriaAhp", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<AlternativAhp> alternativeAhp;
	
	public GoalAhp getGoalAhp() {
		return goalAhp;
	}

	public void setGoalAhp(GoalAhp goalAhp) {
		this.goalAhp = goalAhp;
	}

	public List<CriteriaRating> getCriteriaRatings() {
		return criteriaRatings;
	}

	public void setCriteriaRatings(List<CriteriaRating> criteriaRatings) {
		this.criteriaRatings = criteriaRatings;
	}

	public List<AlternativAhp> getAlternativeAhp() {
		return alternativeAhp;
	}

	public void setAlternativeAhp(List<AlternativAhp> alternativeAhp) {
		this.alternativeAhp = alternativeAhp;
	}
}
