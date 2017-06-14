package com.team3.laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.team3.laps.model.EmployeeLeaveTracker;

public interface EmployeeLeaveTrackerRepository extends JpaRepository<EmployeeLeaveTracker,Integer>{
	
//	@Query("SELECT elt from EmployeeLeaveTracker elt , Employee e WHERE e.name = :ename AND elt.employeeId = e.employeeId")
//	ArrayList<EmployeeLeaveTracker> findLeaveTrackersByename(@Param("ename") String ename);
	
	@Query ("SELECT elt from EmployeeLeaveTracker elt WHERE elt.employeeId =:eId AND elt.leaveTypeId= :typeId")
	EmployeeLeaveTracker findleaveByidByleavetype(@Param("eId") Integer eId, @Param("typeId") Integer typeId);
	
}
