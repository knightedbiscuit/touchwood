package com.team3.laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team3.laps.model.Employee;
import com.team3.laps.model.EmployeeRole;


public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole,String> {

	@Query("SELECT er from EmployeeRole er WHERE er.emp.employeeId=:eid")
	EmployeeRole findEmployeeRoleByeid(@Param("eid") Integer eid);
	
	@Query("SELECT er from EmployeeRole er, Employee e WHERE e.name =:ename AND er.emp.employeeId= e.employeeId")
	EmployeeRole findEmployeeRoleByename(@Param("ename") String ename);
	
	@Query("SELECT e from Employee e, EmployeeRole er WHERE er.role.roleId = :rid AND er.emp.employeeId= e.employeeId")
	ArrayList<Employee> findEmployeesByRoleId(@Param("rid") Integer rid);
	
	@Query("SELECT er.emp from EmployeeRole er, Employee e WHERE e.name =:rname AND er.emp.employeeId= e.employeeId")
	ArrayList<Employee> findEmployeesByRoleName(@Param("rname") String rname);
}
