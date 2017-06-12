package com.team3.laps.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="leaveapp")
@Table(name = "leave")
public class Leave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="employee_id")
	private int employee_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="applied_on", columnDefinition="DATETIME")
	private Date applied_on;
	
	@Column(name="leave_type_id")
	private int leave_type_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="leave_from",  columnDefinition="DATETIME")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date leave_from;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="leave_to",  columnDefinition="DATETIME")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date leave_to;
	
	@Column(name="status")
	private String status;
	
	@Column(name="additional_reasons")
	private String additional_reasons;
	
	@Column(name="contact_details")
	private String contact_details;
	
	@Column(name="work_dessimination")
	private String work_dessimination;
	
	@Column(name="comments")
	private String comments;
	
	public Leave()
	{}

	
	public Leave(int id, int employee_id, Date applied_on, int leave_type_id, Date leave_from, Date leave_to,
			String status, String additional_reasons, String contact_details, String work_dessimination,
			String comments) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.applied_on = applied_on;
		this.leave_type_id = leave_type_id;
		this.leave_from = leave_from;
		this.leave_to = leave_to;
		this.status = status;
		this.additional_reasons = additional_reasons;
		this.contact_details = contact_details;
		this.work_dessimination = work_dessimination;
		this.comments = comments;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public Date getApplied_on() {
		return applied_on;
	}


	public void setApplied_on(Date applied_on) {
		this.applied_on = applied_on;
	}


	public int getLeave_type_id() {
		return leave_type_id;
	}


	public void setLeave_type_id(int leave_type_id) {
		this.leave_type_id = leave_type_id;
	}


	public Date getLeave_from() {
		return leave_from;
	}


	public void setLeave_from(Date leave_from) {
		this.leave_from = leave_from;
	}


	public Date getLeave_to() {
		return leave_to;
	}


	public void setLeave_to(Date leave_to) {
		this.leave_to = leave_to;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getAdditional_reasons() {
		return additional_reasons;
	}


	public void setAdditional_reasons(String additional_reasons) {
		this.additional_reasons = additional_reasons;
	}


	public String getContact_details() {
		return contact_details;
	}


	public void setContact_details(String contact_details) {
		this.contact_details = contact_details;
	}


	public String getWork_dessimination() {
		return work_dessimination;
	}


	public void setWork_dessimination(String work_dessimination) {
		this.work_dessimination = work_dessimination;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	

}
