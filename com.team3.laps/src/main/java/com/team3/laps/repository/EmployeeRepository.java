package com.team3.laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team3.laps.model.Compensation;
import com.team3.laps.model.Employee;
import com.team3.laps.model.Leave;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// param type may has to be string or integer. To be confirmed.

	@Query("SELECT e FROM Employee e WHERE e.name= :un AND e.password = :pwd")
	Employee findEmployeeByNamePwd(@Param("un") String username, @Param("pwd") String password);

	// This is finding all subordinates under the managerName
	@Query("SELECT e.subordinates from Employee e WHERE e.name = :managerName")
	ArrayList<Employee> findSubordinatesByManagerName(@Param("managerName") String managerName);

	// finds a employee's compensations by its name.
	@Query("SELECT e.compensations from Employee e WHERE e.name = :ename")
	ArrayList<Compensation> findCompensationsByeName(@Param("ename") String ename);

//	@Query("SELECT e.employeeLeaves from Employee e WHERE e.name = :ename")
//	ArrayList<Leave> findLeavesByeName(@Param("ename") String ename);

	@Query("SELECT e.subordinates from Employee e WHERE e.id = :managerId")
	ArrayList<Employee> findSubordinatesByManagerId(@Param("managerId") Integer managerId);

	// finds a employee's compensations by its id.
	@Query("SELECT e.compensations from Employee e WHERE e.employeeId = :eid")
	ArrayList<Compensation> findCompensationsByeid(@Param("eid") Integer eid);

//	@Query("SELECT e.employeeLeaves from Employee e WHERE e.employeeId = :eid")
//	ArrayList<Leave> findLeavesByeid(@Param("eid") Integer eid);

	@Query("SELECT e FROM Employee e where e.employeeId = :id")
	Employee findEmployeeById(@Param("id") Integer id);

	@Query("SELECT e FROM Employee e where e.manager.employeeId = :mgrid")
	ArrayList<Employee> findEmployeesByManagerId(@Param("mgrid") Integer mgrid);

	@Query("SELECT DISTINCT m FROM Employee e, Employee m where e.manager.employeeId = m.employeeId")
	ArrayList<Employee> findAllManagers();

	@Query("SELECT DISTINCT m.name FROM Employee e, Employee m where e.manager.employeeId = m.employeeId ")
	ArrayList<String> findAllManagerNames();
}
