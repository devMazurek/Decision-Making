package pl.mazurek.dm.dao.entities.ahp;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import pl.mazurek.dm.dao.entities.AbstractRatingEntity;

@Entity
public class CriteriaRating extends AbstractRatingEntity {
	
	@ManyToOne
	private CriteriaAhp parent;
	
	@ManyToOne
	private CriteriaAhp comparable;

	public CriteriaAhp getParent() {
		return parent;
	}

	public void setParent(CriteriaAhp parent) {
		this.parent = parent;
	}

	public CriteriaAhp getComparable() {
		return comparable;
	}

	public void setComparable(CriteriaAhp comparable) {
		this.comparable = comparable;
	}
}
