package com.team3.laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.team3.laps.model.EmployeeLeaveEntitlement;

public interface EmployeeLeaveEntitlementRepository extends JpaRepository<EmployeeLeaveEntitlement,Integer> {
	
	@Query("SELECT eler from EmployeeLeaveEntitlement eler, Role r WHERE r.description = :rname AND r.roleId = eler.roleId")
	ArrayList<EmployeeLeaveEntitlement> findLeaveEntitlementsByRolename(@Param("rname")String rname);
	
	@Query("SELECT eler from EmployeeLeaveEntitlement eler, LeaveType l WHERE l.description = :ltype AND l.id = eler.leaveTypeId")
	ArrayList<EmployeeLeaveEntitlement> findLeaveEntitlementsByLeaveType(@Param("ltype")String ltype);
	
}
