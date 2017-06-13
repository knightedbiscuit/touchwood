package com.team3.laps.service;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team3.laps.model.Leave;
import com.team3.laps.repository.LeaveRepository;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Resource
	private LeaveRepository leaveRepo;

	@Override
	@Transactional
	public Leave addLeave(Leave leave) {
		return leaveRepo.saveAndFlush(leave);
	}

	@Override
	@Transactional
	public Boolean checkLeavebtwPeriod(Date datefrom, Date dateTo) {
		ArrayList<Leave> lList = null;
		lList = leaveRepo.findLeaveByStartEndDate(datefrom, dateTo);

		if (lList != null) {
			return true;
		} else {
			return true;
		}

	}

}
