package pl.mazurek.dm.dao.ahpdao;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.mazurek.dm.dao.entities.ahp.GoalAhp;

public interface GoalRepository extends JpaRepository<GoalAhp, Long>{

}
