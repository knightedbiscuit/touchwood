package com.team3.laps.controllor;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.team3.laps.model.Employee;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserSession {

	private String sessionId = null;
	private Employee employee = null;
	
	public UserSession() {
		super();
	}

	public UserSession(String sessionId, Employee employee) {
		super();
		this.sessionId = sessionId;
		this.employee = employee;
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
	

	
	
}
