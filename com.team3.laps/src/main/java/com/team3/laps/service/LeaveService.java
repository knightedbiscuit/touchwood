package com.team3.laps.service;

import java.util.Date;

import com.team3.laps.model.Leave;

public interface LeaveService {
	
	public Leave addLeave(Leave leave);
	
	Boolean checkLeavebtwPeriod(Date datefrom, Date dateTo);

}
