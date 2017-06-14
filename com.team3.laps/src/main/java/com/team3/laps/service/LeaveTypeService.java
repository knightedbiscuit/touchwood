package com.team3.laps.service;

import java.util.ArrayList;

import com.team3.laps.model.LeaveType;

public interface LeaveTypeService {

	ArrayList<LeaveType> findAllLeaveTypes();

	LeaveType findLeaveType(Integer ltid);
	
	LeaveType findLeaveTypeByName(String description);
	
	LeaveType createLeaveType(LeaveType leaveType);

	LeaveType changeLeaveType(LeaveType leaveType);
	
	String getLeaveTypeNameByLeaveTypeId(Integer Id);

	void removeLeaveType(LeaveType leaveType);
}
