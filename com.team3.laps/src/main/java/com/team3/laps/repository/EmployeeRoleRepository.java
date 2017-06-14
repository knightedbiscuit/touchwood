package com.team3.laps.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team3.laps.model.EmployeeRole;

public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole,Integer> {

	@Query("SELECT r.description from Role r, EmployeeRole er WHERE er.employeeId = eid AND er.roleId = r.roleId")
	String findRoleByeid(@Param("eid") Integer eid);
	
	@Query("SELECT r.description from EmployeeRole er , Employee e, Role r WHERE e.name =:ename AND er.employeeId = e.employeeId AND r.roleId = er.roleId")
	String findRoleByename(@Param("ename") String ename);
}
