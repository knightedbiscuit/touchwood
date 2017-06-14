package com.team3.laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team3.laps.model.EmployeeLeaveTracker;
import com.team3.laps.repository.EmployeeLeaveTrackerRepository;
import com.team3.laps.repository.EmployeeRepository;

@Service
public class EmployeeLeaveTrackerServiceImpl implements EmployeeLeaveTrackerService{

	@Resource
	private EmployeeLeaveTrackerRepository eltr;

//	@Override
//	@Transactional
//	public double findAvailableLeave(Integer eID,Integer leavetypeID) {
//		double days = 0;
//		String name =null;
////		name = er.findOne(eID).getName();
//		name = "Htet";
//		ArrayList<EmployeeLeaveTracker> ets = eltr.findLeaveTrackersByename(name);
//		for(EmployeeLeaveTracker et:ets){
//			if(et.getLeaveTypeId()==leavetypeID)
//				days = et.getDays();
//			break;
//		}
//		return days;
//	}
	
	@Transactional
	@Override
	public double findAvailableleave(Integer eId, Integer leavetypeId)
	{
		double days = 0;
		days  = eltr.findleaveByidByleavetype(eId, leavetypeId).getDays();
		return days;
		
	}
	
	@Transactional
	@Override
	public EmployeeLeaveTracker updateAvailableLeave(EmployeeLeaveTracker elTracker) {

		return eltr.saveAndFlush(elTracker);
	}

	@Override
	@Transactional
	public EmployeeLeaveTracker findEmployeeTracker(Integer eId, Integer leavetypeId) {
		return eltr.findleaveByidByleavetype(eId, leavetypeId);

	}

//	@Override
//	@Transactional
//	public ArrayList<EmployeeLeaveTracker> findLeaveTrackersByename(String ename) {
//		
//		return eltr.findLeaveTrackersByename(ename);
//	}

}
