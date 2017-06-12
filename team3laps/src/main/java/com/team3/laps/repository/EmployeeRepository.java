package com.team3.laps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team3.laps.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("SELECT e FROM Employee e where e.id = :id")
	Employee findEmployeeById(@Param("id") int id);
	
	@Query("SELECT e FROM Employee e WHERE e.name= :un AND e.password = :pwd")
	Employee findEmployeeByNamePwd(@Param("un") String username, @Param("pwd") String password);

}
