package com.mgmnt.crud.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "pass", length = 15, nullable = false)
	private String pass;

	@ManyToMany(fetch = FetchType.LAZY, cascade =CascadeType.ALL)
	@JoinTable(name = "users_departments", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "department_id") })
	private Set<Department> departments = new HashSet<Department>();


	public void addDepartments(Department department) {
		this.departments.add(department);
		department.getUsers().add(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public void removeDepartments(Department department) {
		this.departments.remove(department);
		department.getUsers().remove(this);
	}
}
