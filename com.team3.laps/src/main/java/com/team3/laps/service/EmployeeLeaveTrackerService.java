package com.team3.laps.service;

import java.util.ArrayList;

import com.team3.laps.model.Employee;



public interface EmployeeLeaveTrackerService {
	
	ArrayList<Employee> findAvailableLeave();
	
	//BingZhao
	double findAvailableLeave(Integer eID, Integer leaveTypeID);

}
