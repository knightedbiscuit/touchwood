package com.team3.laps.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team3.laps.model.Leave;
import com.team3.laps.model.LeaveTypeEnum;
import com.team3.laps.model.StatusEnum;

public interface LeaveService {
	
	Leave addLeave(Leave leave);
	
	Boolean checkLeavebtwPeriod(Date datefrom, Date dateTo);

	ArrayList<Leave> findLeavesByType( LeaveTypeEnum leaveType );
	
	ArrayList<Leave> findLeavesByStatus( StatusEnum status );
	
	ArrayList<Leave> findLeavesByAppliedDate( Date appliedOn );

	ArrayList<Leave> findLeavesByStartDate( Date FromDate );

	ArrayList<Leave> findLeavesByEndDate( Date ToDate );
	
	ArrayList<Leave> findPendingLeavesByeid( int eid);
	
	ArrayList<Leave> findApprovedLeavesByeid(int eid);
	
	ArrayList<Leave> findRejectedLeavesByeid(int eid);
	
	ArrayList<Leave> findCancelledLeavesByeid( int eid);

}
