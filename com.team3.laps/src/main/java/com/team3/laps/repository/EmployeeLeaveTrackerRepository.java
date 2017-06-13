package com.team3.laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team3.laps.model.EmployeeLeaveEntitlement;
import com.team3.laps.model.EmployeeLeaveTracker;

public interface EmployeeLeaveTrackerRepository extends JpaRepository<EmployeeLeaveEntitlement,Integer>{

	
	
//	@Query("SELECT elt.days from EmployeeLeaveTracker elt "
//			+ "WHERE elt.employeeId=:eid AND "
//			+ "elt.leaveTypeId = :ltid")
//	double findAvailableLeaveDaysByeidAndleaveTypeId(@Param("eid") Integer eid,@Param("ltid") Integer ltid);
	
	@Query("SELECT elt from EmployeeLeaveTracker elt "
			+ "WHERE elt.employeeId=:eid AND "
			+ "elt.leaveTypeId = :ltid")
	EmployeeLeaveTracker findEmployeeLeaveTrackerByeidAndleaveTypeId(@Param("eid") Integer eid,@Param("ltid") Integer ltid);
//	
//	@Query("SELECT elt.days from EmployeeLeaveTracker elt "
//			+ "WHERE elt.emp.name = :ename"
//			+ " AND elt.leavetype.description = :ltname")
//	double findAvailableLeaveDaysByenameAndleaveType(@Param("ename") String ename, @Param("ltname") String name);
//	
//	@Query("SELECT elt from EmployeeLeaveTracker elt WHERE "
//			+ "elt.employeeId = :eid")
//	ArrayList<EmployeeLeaveTracker> findLeaveTrackersByeid(@Param("eid") Integer eid);
//	
//	@Query("SELECT elt from EmployeeLeaveTracker elt WHERE "
//			+ "elt.emp.name = :ename")
//	ArrayList<EmployeeLeaveTracker> findLeaveTrackersByename(@Param("ename") String ename);
}
