package com.team3.laps.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.team3.laps.model.LeaveType;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="employee-leave_entitlement")
public class EmployeeLeaveEntitlement {

	@Id
	@Column(name="pk_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pkId;
	
	@Column(name="leave_type_id")
	private Integer leaveTypeId;
	
	@Column(name="role_id")
	private Integer roleId;
	
	@Column(name="days")
	private double days;

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
