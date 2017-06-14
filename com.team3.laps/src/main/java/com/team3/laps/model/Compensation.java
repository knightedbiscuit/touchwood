package com.team3.laps.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="employee_id")
	private Integer employeeId;
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="employee_id",referencedColumnName="id")
//	private Employee emp;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="claim_from")
	private Date claimFrom;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="claim_to")
	private Date claimTo;
	
	@Column(name="overtime_clocked")
	private double overtimeClocked;
	
	@Column(name="reasons")
	private String reasons;
	
	@Column(name="status")
	private String status;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compensation other = (Compensation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
