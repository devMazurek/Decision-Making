package pl.mazurek.dm.dao.entities.ahp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import pl.mazurek.dm.dao.entities.AbstractRatingEntity;

@Entity
public class AlternativRating extends AbstractRatingEntity {

	@ManyToOne
	private AlternativAhp parent;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	private AlternativAhp comparable;
	
	@ManyToOne
	private CriteriaAhp criteriaAhp;

	public AlternativAhp getParent() {
		return parent;
	}

	public void setParent(AlternativAhp parent) {
		this.parent = parent;
	}

	public AlternativAhp getComarable() {
		return comparable;
	}

	public void setComarable(AlternativAhp comparable) {
		this.comparable = comparable;
	}

	public CriteriaAhp getCriteriaAhp() {
		return criteriaAhp;
	}

	public void setCriteriaAhp(CriteriaAhp criteriaAhp) {
		this.criteriaAhp = criteriaAhp;
	}
	
	
}
