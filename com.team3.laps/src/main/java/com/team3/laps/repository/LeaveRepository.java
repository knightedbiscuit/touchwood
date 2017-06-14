package com.team3.laps.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team3.laps.model.Leave;
import com.team3.laps.model.LeaveTypeEnum;
import com.team3.laps.model.StatusEnum;

public interface LeaveRepository extends JpaRepository<Leave, Integer> {

	@Query("SELECT l from Leave l WHERE l.leaveTypeId = :lType")
	ArrayList<Leave> findLeavesByTypeID(@Param("lType")Integer lType);
	
	@Query("SELECT l from Leave l WHERE l.leaveTo >= :dateTo AND l.leaveFrom <= :dateFrom" )
	ArrayList<Leave> findLeaveByStartEndDate(@Param("dateTo") Date dateTo, @Param("dateFrom") Date dateFrom );
	
	@Query("SELECT l from Leave l, LeaveType lt WHERE lt.description = :leaveType AND l.leaveTypeId = lt.id")
	ArrayList<Leave> findLeavesByType(@Param("leaveType") LeaveTypeEnum leaveType );
	
	@Query("SELECT l from Leave l WHERE l.status = :status")
	ArrayList<Leave> findLeavesByStatus(@Param("status") StatusEnum status );
	
	@Query("SELECT l from Leave l WHERE l.appliedOn = :appliedOn")
	ArrayList<Leave> findLeavesByAppliedDate(@Param("appliedOn") Date appliedOn );

	@Query("SELECT l from Leave l WHERE l.leaveFrom = :FromDate")
	ArrayList<Leave> findLeavesByStartDate(@Param("FromDate") Date FromDate );

	@Query("SELECT l from Leave l WHERE l.leaveTo = :ToDate")
	ArrayList<Leave> findLeavesByEndDate(@Param("ToDate") Date ToDate );
	
	@Query("SELECT l from Leave l WHERE l.employeeId = :eid AND (l.status ='Applied' OR l.status ='Updated')")
	ArrayList<Leave> findPendingLeavesByeid(@Param("eid") int eid);
	
	@Query("SELECT l from Leave l where l.employeeId = :eid AND (l.status = 'Approved')")
	ArrayList<Leave> findApprovedLeavesByeid(@Param("eid") int eid);
	
	@Query("SELECT l from Leave l where l.employeeId = :eid AND (l.status = 'Rejected')")
	ArrayList<Leave> findRejectedLeavesByeid(@Param("eid") int eid);
	
	@Query("SELECT l from Leave l where l.employeeId = :eid AND (l.status = 'Cancelled')")
	ArrayList<Leave> findCancelledLeavesByeid(@Param("eid") int eid);

}
