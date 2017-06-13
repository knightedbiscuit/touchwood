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


@Entity
@Table(name = "employee-leave_tracker")
public class EmployeeLeaveTracker {
	
	@Id
	@Column(name="pk_id")
	private Integer pkId;
	
	@Column(name = "employee_id",insertable=false ,updatable=false)
	private Integer employeeId;

	@Column(name = "leave_type_id",insertable=false ,updatable=false)
	private Integer leaveTypeId;
	
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

	public EmployeeLeaveTracker(Integer employeeId, Integer leaveTypeId, double days) {
		super();
		this.employeeId = employeeId;
		this.leaveTypeId = leaveTypeId;
		this.days = days;
	}


}
