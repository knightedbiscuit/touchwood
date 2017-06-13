package com.team3.laps.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team3.laps.model.LeaveType;
import com.team3.laps.repository.LeaveTypeRepository;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {
	
	@Resource
	LeaveTypeRepository leaveRepo;
	
	@Transactional
	@Override
	public LeaveType getLeaveType(Integer id) {
		return leaveRepo.findOne(id);
	}

}
