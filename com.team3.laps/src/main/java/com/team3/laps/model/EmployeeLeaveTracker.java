package com.team3.laps.model;

import javax.persistence.Basic;
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

@Entity
@Table(name = "employee_leave_tracker")
public class EmployeeLeaveTracker {
	
	@Id
	@Column(name="pk_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pkId;
	
	@Column(name = "employee_id")
	private Integer employeeId;

	@Column(name = "leave_type_id")
	private Integer leaveTypeId;
	
	@Basic
	@Column(name = "days")
	private double days;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public double getDays() {
		return days;
	}

	public void setDays(double days) {
		this.days = days;
	}
	
    

}
