package com.team3.laps.service;

import com.team3.laps.model.Employee;

public interface EmployeeService {

	public Employee findEmployeeById(int i);
	public Employee authenticate(String username, String password);
}
