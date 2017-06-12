package com.team3.laps.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team3.laps.model.LeaveType;



public interface LeaveTypeRepository extends JpaRepository<LeaveType, String>{

	@Query("SELECT lp.description from LeaveType lp where lp.id = :id")
	String getLeaveTypeNameByLeaveTypeId(@Param("id") Integer id);
	
	@Query("SELECT lp.id from LeaveType lp where lp.description = :name")
	String getLeaveTypeIdByLeaveTypeName(@Param("name") String name);
	
	@Query("SELECT lp from LeaveType lp where lp.description = :name")
	LeaveType findLeaveTypeByLeaveTypeName(@Param("name") String name);
		
}
