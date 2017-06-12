package com.team3.laps.model;

import java.io.Serializable;

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

@Entity
@Table(name = "employee-leave_tracker")
public class EmployeeLeaveTracker implements Serializable  {
	
	
	
	@Id
	@Column(name = "employee_id")
	private int employeeId;
	
	@Id
	@Column(name = "leave_type_id")
	private int leaveTypeId;
	
	@Basic
	@Column(name = "days")
	private double days;
	
	@OneToOne(targetEntity = Employee.class,cascade=CascadeType.ALL)
	@JoinColumn(name="employee_id",referencedColumnName="id")
    private Employee emp;
	
	@OneToOne(targetEntity = LeaveType.class,cascade=CascadeType.ALL)
	@JoinColumn(name="leave_type_id",referencedColumnName="id")
    private LeaveType leavetype;

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public LeaveType getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(LeaveType leavetype) {
		this.leavetype = leavetype;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public double getDays() {
		return days;
	}

	public void setDays(double days) {
		this.days = days;
	}

	public EmployeeLeaveTracker(int employeeId, int leaveTypeId, double days) {
		super();
		this.employeeId = employeeId;
		this.leaveTypeId = leaveTypeId;
		this.days = days;
	}


}
