package com.team3.laps.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee-role")
public class EmployeeRole {
	
	@Id
	@Column(name="pk_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pkId;
	
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="role_id")
	private Integer roleId;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	
	
}
