package com.team3.laps.service;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team3.laps.model.Leave;
import com.team3.laps.model.LeaveTypeEnum;
import com.team3.laps.model.StatusEnum;
import com.team3.laps.repository.LeaveRepository;
@Service
public class LeaveServiceImpl implements LeaveService{

	@Resource
	private LeaveRepository lR;
	
	@Override
	@Transactional
	public Leave addLeave(Leave leave) {
		return lR.saveAndFlush(leave);
	}

	@Override
	@Transactional
	public ArrayList<Leave> findLeavesByType(LeaveTypeEnum leaveType) {
		// TODO Auto-generated method stub
		return lR.findLeavesByType(leaveType);
	}

	@Override
	@Transactional
	public ArrayList<Leave> findLeavesByStatus(StatusEnum status) {
		// TODO Auto-generated method stub
		return lR.findLeavesByStatus(status);
	}

	@Override
	@Transactional
	public ArrayList<Leave> findLeavesByAppliedDate(Date appliedOn) {
		// TODO Auto-generated method stub
		return lR.findLeavesByAppliedDate(appliedOn);
	}

	@Override
	@Transactional
	public ArrayList<Leave> findLeavesByStartDate(Date FromDate) {
		// TODO Auto-generated method stub
		return lR.findLeavesByStartDate(FromDate);
	}

	@Override
	@Transactional
	public ArrayList<Leave> findLeavesByEndDate(Date ToDate) {
		// TODO Auto-generated method stub
		return lR.findLeavesByEndDate(ToDate);
	}

	@Override
	@Transactional
	public ArrayList<Leave> findPendingLeavesByeid(int eid) {
		// TODO Auto-generated method stub
		return lR.findPendingLeavesByeid(eid);
	}

	@Override
	@Transactional
	public ArrayList<Leave> findApprovedLeavesByeid(int eid) {
		// TODO Auto-generated method stub
		return lR.findApprovedLeavesByeid(eid);
	}

	@Override
	@Transactional
	public ArrayList<Leave> findRejectedLeavesByeid(int eid) {
		// TODO Auto-generated method stub
		return lR.findRejectedLeavesByeid(eid);
	}

	@Override
	@Transactional
	public ArrayList<Leave> findCancelledLeavesByeid(int eid) {
		// TODO Auto-generated method stub
		return lR.findCancelledLeavesByeid(eid);
	}

	@Override
	public ArrayList<Leave> findLeavesByTypeID(Integer lType) {
		
		return lR.findLeavesByTypeID(lType);
	
	}
}
