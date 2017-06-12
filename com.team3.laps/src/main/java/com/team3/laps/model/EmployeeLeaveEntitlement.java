package com.team3.laps.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee-leave_entitlement")
@IdClass(EmployeeLeaveEntitlement.class)
public class EmployeeLeaveEntitlement implements Serializable {

//	@Id
//	@Column(name="leave_type_id")
//	private int leaveTypeId;
//	
//	@Id
//	@Column(name="role_id")
//	private int roleId;
	
	@Column(name="days")
	private double days;
	
	@Id
	@OneToOne(targetEntity = LeaveType.class,cascade=CascadeType.ALL)
	@JoinColumn(name="leave_type_id",referencedColumnName="id")
    private LeaveType leavetype;
	
	@Id
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

//	public int getLeaveTypeId() {
//		return leaveTypeId;
//	}
//
//	public void setLeaveTypeId(int leaveTypeId) {
//		this.leaveTypeId = leaveTypeId;
//	}
//
//	public int getRoleId() {
//		return roleId;
//	}
//
//	public void setRoleId(int roleId) {
//		this.roleId = roleId;
//	}

	public double getDays() {
		return days;
	}

	public void setDays(double days) {
		this.days = days;
	}
	
}
