package com.team3.laps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team3.laps.model.Leave;

public interface LeaveRepository extends JpaRepository<Leave,Integer>{
	
}
