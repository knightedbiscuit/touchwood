package com.team3.laps.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="compensation")
public class Compensation {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="employee_id")
	private int employeeId;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/mm/dd")
	@Column(name="claim_from")
	private Date claimFrom;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/mm/dd")
	@Column(name="claim_to")
	private Date claimTo;
	
	@Column(name="overtime_clocked")
	private double overtimeClocked;
	
	@Column(name="reasons")
	private String reasons;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne(targetEntity = Employee.class, cascade=CascadeType.ALL)
	@JoinColumn(name="empolyee_id",referencedColumnName="id")
	private Employee emp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getClaimFrom() {
		return claimFrom;
	}

	public void setClaimFrom(Date claimFrom) {
		this.claimFrom = claimFrom;
	}

	public Date getClaimTo() {
		return claimTo;
	}

	public void setClaimTo(Date claimTo) {
		this.claimTo = claimTo;
	}

	public double getOvertimeClocked() {
		return overtimeClocked;
	}

	public void setOvertimeClocked(double overtimeClocked) {
		this.overtimeClocked = overtimeClocked;
	}

	public String getReasons() {
		return reasons;
	}

	public void setReasons(String reasons) {
		this.reasons = reasons;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	
}
