package pl.mazurek.dm.dao.entities.ahp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import pl.mazurek.dm.dao.entities.AbstractDacisionMakingEntity;
import pl.mazurek.dm.dao.entities.GoalEntity;
import pl.mazurek.dm.dao.entities.common.ProjectEntity;

@Entity
public class GoalAhp extends AbstractDacisionMakingEntity implements GoalEntity{

	@OneToOne
	private ProjectEntity projectEntity;
	
	@OneToMany(mappedBy = "goalAhp", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<CriteriaAhp> criteriaAhps;

	@OneToMany(mappedBy = "goalAhp", cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<AlternativAhp> alternativAhps;
	
	public ProjectEntity getProjectEntity() {
		return projectEntity;
	}

	public void setProjectEntity(ProjectEntity projectEntity) {
		this.projectEntity = projectEntity;
	}

	public List<CriteriaAhp> getCriteriaAhps() {
		return criteriaAhps;
	}

	public void setCriteriaAhps(List<CriteriaAhp> criteriaAhps) {
		this.criteriaAhps = criteriaAhps;
	}

	public List<AlternativAhp> getAlternativAhps() {
		return alternativAhps;
	}

	public void setAlternativAhps(List<AlternativAhp> alternativAhps) {
		this.alternativAhps = alternativAhps;
	}
}
