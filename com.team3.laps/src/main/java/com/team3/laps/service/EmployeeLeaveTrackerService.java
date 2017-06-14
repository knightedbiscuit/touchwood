package com.team3.laps.service;

import java.util.ArrayList;
import com.team3.laps.model.EmployeeLeaveTracker;

public interface EmployeeLeaveTrackerService {

	EmployeeLeaveTracker updateAvailableLeave(EmployeeLeaveTracker elTracker);
	
//	ArrayList<EmployeeLeaveTracker> findLeaveTrackersByename(String ename);

	double findAvailableleave(Integer eId, Integer leavetypeId);
	
	EmployeeLeaveTracker findEmployeeTracker(Integer eId, Integer leavetypeId);
}
