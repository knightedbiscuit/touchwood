package com.team3.laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.team3.laps.model.Employee;
import com.team3.laps.model.EmployeeLeaveTracker;
import com.team3.laps.repository.EmployeeLeaveTrackerRepository;



@Service
public class EmployeeLeaveTrackerServiceImpl implements EmployeeLeaveTrackerService {

	@Resource
	EmployeeLeaveTrackerRepository employeeTrackerRepo;
	
	@Override
	public ArrayList<Employee> findAvailableLeave() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double findAvailableLeave(Integer eId, Integer leaveTypeID) {
		EmployeeLeaveTracker eLT;
		eLT = employeeTrackerRepo.findEmployeeLeaveTrackerByeidAndleaveTypeId(eId,leaveTypeID);
		return eLT.getDays();

	}

}
