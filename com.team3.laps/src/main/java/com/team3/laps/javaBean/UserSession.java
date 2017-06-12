package com.team3.laps.javaBean;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.team3.laps.model.Compensation;
import com.team3.laps.model.Employee;
import com.team3.laps.model.Leave;

import org.springframework.context.annotation.ScopedProxyMode;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession{

	private String sessionId = null;
	private Employee employee = null;//who is the user,corresponding to userBean.user
	private ArrayList<Employee> subordinates = null;
	private ArrayList<Compensation> Compensations = null;
	private ArrayList<Leave> leaves =null;
	
	public UserSession() {
		super();
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public ArrayList<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(ArrayList<Employee> subordinates) {
		this.subordinates = subordinates;
	}

	public ArrayList<Compensation> getCompensations() {
		return Compensations;
	}

	public void setCompensations(ArrayList<Compensation> compensations) {
		Compensations = compensations;
	}

	public ArrayList<Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(ArrayList<Leave> leaves) {
		this.leaves = leaves;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
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
		UserSession other = (UserSession) obj;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		return true;
    }
}
