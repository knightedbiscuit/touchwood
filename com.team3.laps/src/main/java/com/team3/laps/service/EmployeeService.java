package com.team3.laps.service;

import java.util.ArrayList;

import com.team3.laps.model.Employee;
import com.team3.laps.model.EmployeeLeaveTracker;


public interface EmployeeService {
	
	public Employee findEmployeeById(int i);
	public Employee authenticate(String username, String password);
	
	ArrayList<Employee> findSubordinates();
	
	ArrayList<EmployeeLeaveTracker> findLeaveDays();
	
	Employee addEmployee(Employee employee);
	
	Employee removeEmployee(Employee employee);
	
}
