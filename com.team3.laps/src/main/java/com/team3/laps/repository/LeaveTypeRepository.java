package com.team3.laps.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team3.laps.model.LeaveType;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, Integer>{
	@Query("SELECT lt from LeaveType lt WHERE lt.description =:description")
	LeaveType findLeaveTypeByName(@Param("description")String description);
}
