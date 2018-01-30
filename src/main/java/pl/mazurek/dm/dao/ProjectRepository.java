package pl.mazurek.dm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.mazurek.dm.dao.entities.common.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long>{

	public List<ProjectEntity> getProjectByName();
}
