package com.team3.laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team3.laps.model.Compensation;
import com.team3.laps.model.Employee;
import com.team3.laps.model.Leave;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	@Query("SELECT DISTINCT m from Employee m , Employee e WHERE m.name = :Name AND e.managerId = m.employeeId")
	ArrayList<Employee> findSubordinatesByName(@Param("Name") String Name );
	
	@Query("SELECT e from Employee e WHERE e.name = :ename")
	Employee findEmployeeByName(@Param("ename") String ename);
		
	@Query("SELECT DISTINCT m FROM Employee e, Employee m where e.managerId = m.employeeId ")
	ArrayList<Employee> findAllManagers();

	@Query("SELECT DISTINCT m.name FROM Employee e, Employee m where e.managerId = m.employeeId ")
	ArrayList<String> findAllManagerNames();
	
	@Query("SElECT e from Employee e WHERE e.name =:loginname AND e.password =:pwd")
	Employee findEmployeeLogin(@Param("loginname") String loginname,@Param("pwd") String pwd);
	
	@Query("SELECT e.employeeId from Employee e")
	ArrayList<String> findAllEmployeeids();
	
	@Query("SELECT c from Compensation c ,Employee e WHERE e.employeeId =:eid AND c.employeeId = e.employeeId")
	ArrayList<Compensation> findCompensationsByeid(@Param("eid") Integer eid);
	 
	@Query("SELECT l from Leave l, Employee e WHERE e.employeeId =:eid AND e.employeeId = l.employeeId")
	ArrayList<Leave> findLeavesByeid(@Param("eid") Integer eid);
}
