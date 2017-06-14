package com.team3.laps.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.team3.laps.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
}
