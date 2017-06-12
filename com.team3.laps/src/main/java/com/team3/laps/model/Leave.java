package com.team3.laps.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="leave")
public class Leave {

	@Id
	@Column(name="id")
	private int id;
	
//	@Column(name="employee_id")
//	private int employeeId;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name="applied_on")
	private Date appliedOn;
	
//	@Column(name="leave_type_id")
//	private String leaveTypeId;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name="leave_from")
	private Date leaveFrom;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name="leave_to")
	private Date leaveTo;
	
	@Column(name="status")
	private String status;
	
	@Column(name="additional_reasons")
	private String additionalReasons;
	
	@Column(name="contact_details")
	private String contactDetails;
	
	@Column(name="work_dessimination")
	private String workDessimination;
	
	@Column(name="comments")
	private String comments;
	
	@ManyToOne(targetEntity = Employee.class,cascade=CascadeType.ALL)
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public int getEmployeeId() {
//		return employeeId;
//	}
//
//	public void setEmployeeId(int employeeId) {
//		this.employeeId = employeeId;
//	}

	public Date getAppliedOn() {
		return appliedOn;
	}

	public void setAppliedOn(Date appliedOn) {
		this.appliedOn = appliedOn;
	}

//	public String getLeaveTypeId() {
//		return leaveTypeId;
//	}
//
//	public void setLeaveTypeId(String leaveTypeId) {
//		this.leaveTypeId = leaveTypeId;
//	}

	public Date getLeaveFrom() {
		return leaveFrom;
	}

	public void setLeaveFrom(Date leaveFrom) {
		this.leaveFrom = leaveFrom;
	}

	public Date getLeaveTo() {
		return leaveTo;
	}

	public void setLeaveTo(Date leaveTo) {
		this.leaveTo = leaveTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdditionalReasons() {
		return additionalReasons;
	}

	public void setAdditionalReasons(String additionalReasons) {
		this.additionalReasons = additionalReasons;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getWorkDessimination() {
		return workDessimination;
	}

	public void setWorkDessimination(String workDessimination) {
		this.workDessimination = workDessimination;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
