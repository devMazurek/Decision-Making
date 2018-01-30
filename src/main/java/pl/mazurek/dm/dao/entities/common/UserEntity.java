package pl.mazurek.dm.dao.entities.common;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import pl.mazurek.dm.common.Role;
import pl.mazurek.dm.dao.entities.BussinesEntity;

@Entity
public class UserEntity implements BussinesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String login;

	@Column
	private String password;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
	private List<ProjectEntity> projectEntities;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<ProjectEntity> getProjectEntities() {
		return projectEntities;
	}

	public void setProjectEntities(List<ProjectEntity> projectEntities) {
		this.projectEntities = projectEntities;
	}

}
