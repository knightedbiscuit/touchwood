package com.team3.laps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team3.laps.model.EmployeeLeaveEntitlement;

public interface EmployeeLeaveEntitlementRepository extends JpaRepository<EmployeeLeaveEntitlement,String> {

	@Query("SELECT eler from EmployeeLeaveEntitlement eler "
			+ "WHERE eler.leavetype.id = :ltid"
			+ " AND eler.role.roleId = :rid")
	EmployeeLeaveEntitlement findLeaveEntitlementByRoleidLeaveTypeId(@Param("ltid")Integer ltid,@Param("rid")Integer rid);
	
	@Query("SELECT eler from EmployeeLeaveEntitlement eler "
			+ "WHERE eler.leavetype.description = :ltname"
			+ " AND eler.role.description = :rname")
	EmployeeLeaveEntitlement findLeaveEntitlementByRolenameLeaveTypename(@Param("ltname")String ltname,@Param("rname")String rname);
}
