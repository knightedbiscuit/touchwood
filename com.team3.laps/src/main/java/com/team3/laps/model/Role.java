package com.team3.laps.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="role")
public class Role {
	@Id
	@Column(name="id")
	private int roleId;
	
	@Column(name="description")
	private String description;
	
	/** Container for Roles **/
	@OneToMany (targetEntity = Employee.class,mappedBy="role",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	List<Employee> employeesOfTheRole= new ArrayList<Employee>();

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getlistOfEmployees() {
		return employeesOfTheRole;
	}

	public void setemployeesOfTheRole(ArrayList<Employee> employeesOfTheRole) {
		this.employeesOfTheRole = employeesOfTheRole;
	}

	public Role(int role_id, String Description, ArrayList<Employee> employeesOfTheRole) {
		super();
		roleId = role_id;
		description = Description;
		this.employeesOfTheRole = employeesOfTheRole;
	}

	@Override
	public String toString() {
		return "Role [description=" + description + "]";
	}
	
}
