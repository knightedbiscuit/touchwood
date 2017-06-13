package com.team3.laps.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="leave_info")
public class Leave implements Serializable{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="applied_on")
	private Date appliedOn;
	
	@Column(name="leave_type_id")
	private Integer leaveTypeId;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="leave_from")
	private Date leaveFrom;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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
	
//	@ManyToOne(targetEntity = Employee.class,cascade=CascadeType.ALL)
//	@JoinColumn(name="employee_id" ,referencedColumnName="id")
//    private Employee emp;
//	
//	@OneToOne(targetEntity = LeaveType.class,cascade=CascadeType.ALL)
//	@JoinColumn(name="leave_type_id",referencedColumnName="id")
//    private LeaveType leavetype;

//	public Employee getEmp() {
//		return emp;
//	}
//
//	public void setEmp(Employee emp) {
//		this.emp = emp;
//	}
//
//	public LeaveType getLeavetype() {
//		return leavetype;
//	}
//
//	public void setLeavetype(LeaveType leavetype) {
//		this.leavetype = leavetype;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Date getAppliedOn() {
		return appliedOn;
	}

	public void setAppliedOn(Date appliedOn) {
		this.appliedOn = appliedOn;
	}

	public Integer getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(Integer leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

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
