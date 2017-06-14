package com.team3.laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team3.laps.model.LeaveType;
import com.team3.laps.repository.LeaveTypeRepository;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService{

	@Resource
	private LeaveTypeRepository ltR;
	
	@Override
	@Transactional
	public ArrayList<LeaveType> findAllLeaveTypes() {
		// TODO Auto-generated method stub
		return (ArrayList<LeaveType>) ltR.findAll();
	}

	@Override
	@Transactional
	public LeaveType findLeaveType(Integer ltid) {
		// TODO Auto-generated method stub
		return ltR.findOne(ltid);
	}

	@Override
	@Transactional
	public LeaveType createLeaveType(LeaveType leaveType) {
		// TODO Auto-generated method stub
		return ltR.saveAndFlush(leaveType);
	}

	@Override
	@Transactional
	public LeaveType changeLeaveType(LeaveType leaveType) {
		//
		return ltR.saveAndFlush(leaveType);
	}

	@Override
	@Transactional
	public void removeLeaveType(LeaveType leaveType) {
		// TODO Auto-generated method stub
		ltR.delete(leaveType);
	}

	@Override
	@Transactional
	public String getLeaveTypeNameByLeaveTypeId(Integer Id) {
		LeaveType lp =ltR.findOne(Id);
		return lp.getDescription().toString();
	}

	@Override
	@Transactional
	public LeaveType findLeaveTypeByName(String description) {
		// TODO Auto-generated method stub
		return ltR.findLeaveTypeByName(description);
	}

}
