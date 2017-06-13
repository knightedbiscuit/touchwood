package com.team3.laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team3.laps.model.Compensation;

public interface CompensationRepository extends JpaRepository<Compensation,Integer>{

	@Query("SELECT c from Compensation c WHERE c.employeeId = :eid")
	ArrayList<Compensation> findCompensationsByeid(@Param("eid")Integer eid);
	
	@Query("SELECT c from Compensation c WHERE c.emp.name = :ename")
	ArrayList<Compensation> findCompensationsByename(@Param("ename")String ename);
	
	@Query("SELECT c from Compensation c WHERE c.status = :status")
	ArrayList<Compensation> findAllCompensationsByStatus(@Param("status")String status);
	
	@Query("SELECT c from Compensation c WHERE c.status = :status AND c.emp.name = :ename")
	ArrayList<Compensation> findCompensationsByStatusAndename(@Param("status")String status,@Param("ename") String ename);
	
	@Query("SELECT c from Compensation c WHERE c.status = :status AND c.employeeId = :eid")
	ArrayList<Compensation> findCompensationsByStatusAndeid(@Param("status")String status,@Param("eid") Integer eid);
}
