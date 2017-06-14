package com.team3.laps.service;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team3.laps.model.Compensation;
import com.team3.laps.model.Employee;
import com.team3.laps.model.Leave;


public interface EmployeeService {
	
	ArrayList<Employee> findSubordinatesByName(String Name );
	
	Employee findEmployeeByName(String ename);
		
	ArrayList<Employee> findAllManagers();
	
	ArrayList<String> findAllManagerNames();
	
	ArrayList<Employee> findAllEmployees();

	Employee findEmployee(Integer eid);

	Employee createEmployee(Employee e);

	Employee changeEmployee(Employee e);
	
	void addEmployee(Employee e);
	
	ArrayList<String> findAllEmployeeids();

	void removeEmployee(Employee e);
	
	Employee findEmployeeLogin(String loginname, String pwd);

	ArrayList<Compensation> findCompensationsByeid(Integer eid);
	
	ArrayList<Leave> findLeavesByeid(Integer eid);

}
