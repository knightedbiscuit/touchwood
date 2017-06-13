package com.team3.laps.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team3.laps.model.Leave;


public interface LeaveRepository extends JpaRepository<Leave, Integer> {
	
	@Query("SELECT l from Leave l WHERE l.leaveTo <= :dateTo AND l.leaveFrom >= :dateFrom" )
	ArrayList<Leave> findLeaveByStartEndDate(@Param("dateTo") Date dateTo, @Param("dateFrom") Date dateFrom );

//	@Query("SELECT l from Leave l WHERE l.emp.employeeId = :eid")
//	ArrayList<Leave> findLeavesByeid(@Param("eid") Integer eid );
	
//	@Query("SELECT l from Leave l, Employee e WHERE e.name = :ename AND e.employeeId = l.emp.employeeId")
//	ArrayList<Leave> findLeavesByename(@Param("ename") String ename );
	
//	@Query("SELECT l from Leave l, LeaveType lp WHERE lp.description = :leaveType AND l.leavetype.id = lp.id")
//	ArrayList<Leave> findLeavesByType(@Param("leaveType") String leaveType );
//	
//	@Query("SELECT l from Leave l WHERE l.status = :status")
//	ArrayList<Leave> findLeavesByStatus(@Param("status") String status );
	
//	@Query("SELECT l from Leave l WHERE l.status = :status AND l.emp.employeeId = :eid")
//	ArrayList<Leave> findLeavesByStatusAndeid(@Param("status") String status, @Param("eid") Integer eid);
	
//	@Query("SELECT l from Leave l, Employee e WHERE l.status = :status AND e.name = :ename AND l.emp.employeeId = e.employeeId")
//	ArrayList<Leave> findLeavesByStatusAndename(@Param("status") String status,@Param("ename") String ename);
	
	//it may not works.....
//	@Query("SELECT l from Leave l WHERE l.appliedOn = :appliedOn")
//	ArrayList<Leave> findLeavesByAppliedDate(@Param("appliedOn") Date appliedOn );
	//it may not works neither....
//	@Query("SELECT l from Leave l WHERE l.leaveFrom = :FromDate")
//	ArrayList<Leave> findLeavesByStartDate(@Param("FromDate") Date FromDate );
	//well...
//	@Query("SELECT l from Leave l WHERE l.leaveTo = :ToDate")
//	ArrayList<Leave> findLeavesByEndDate(@Param("ToDate") Date ToDate );
	
	//@Query("SELECT l from Leave l WHERE l.appliedOn < :appliedOn")
	//ArrayList<Leave> findLeavesBeforeAppliedDate(@Param("appliedOn") Date appliedOn );
	
//	@Query("SELECT l from Leave l WHERE l.emp.employeeId = :eid AND l.leavetype.description = :ltp")
//	ArrayList<Leave> findLeavesByeidAndType(@Param("eid") Integer eid,@Param("ltp") String ltp);
//	
//	@Query("SELECT l from Leave l, Employee e WHERE e.name = :ename AND e.employeeId = l.emp.employeeId AND l.leavetype.description = :ltp")
//	ArrayList<Leave> findLeavesByenameAndLeaveType(@Param("ename") String ename, @Param("ltp") String ltp );
	
}
