package pl.mazurek.dm.dao.entities.ahp;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import pl.mazurek.dm.dao.entities.AbstractDacisionMakingEntity;
import pl.mazurek.dm.dao.entities.GoalEntity;
import pl.mazurek.dm.dao.entities.common.ProjectEntity;

@Entity
public class GoalAhp extends AbstractDacisionMakingEntity implements GoalEntity{

	@OneToOne
	private ProjectEntity projectEntity;
	
	@OneToMany(mappedBy = "goalAhp", cascade = CascadeType.ALL)
	private List<CriteriaAhp> criteriaAhps;

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
}
