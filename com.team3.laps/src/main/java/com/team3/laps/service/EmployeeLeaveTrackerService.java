package com.team3.laps.service;

import java.util.ArrayList;

import com.team3.laps.model.Employee;
import com.team3.laps.model.EmployeeLeaveTracker;



public interface EmployeeLeaveTrackerService {
	
	ArrayList<Employee> findAvailableLeave();

	double findAvailableLeave(Integer eId, Integer leaveTypeID);
	
	//BingZhao
//	public double findAvailableLeave(Integer eID, Integer leaveTypeID);
//	public EmployeeLeaveTracker updateAvailableLeave(EmployeeLeaveTracker elTracker);

}
