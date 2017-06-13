package com.team3.laps.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="employee-leave_entitlement")
public class EmployeeLeaveEntitlement {

	@Id
	@Column(name="pk_id")
	private Integer pkId;
	
	@Column(name="leave_type_id",insertable=false ,updatable=false)
	private Integer leaveTypeId;
	
	@Column(name="role_id",insertable=false ,updatable=false)
	private Integer roleId;
	
	@Column(name="days")
	private double days;
	
	@OneToOne(targetEntity = LeaveType.class,cascade=CascadeType.ALL)
	@JoinColumn(name="leave_type_id",referencedColumnName="id")
    private LeaveType leavetype;
	
	@OneToOne(targetEntity = Role.class,cascade=CascadeType.ALL)
	@JoinColumn(name="role_id",referencedColumnName="id")
	private Role role;
    
	public LeaveType getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(LeaveType leavetype) {
		this.leavetype = leavetype;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public double getDays() {
		return days;
	}

	public void setDays(double days) {
		this.days = days;
	}
	
}
