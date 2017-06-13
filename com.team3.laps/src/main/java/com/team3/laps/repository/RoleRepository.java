package com.team3.laps.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team3.laps.model.Role;



public interface RoleRepository extends JpaRepository<Role, Integer>{

	@Query("SELECT r.roleId from Role r WHERE r.description = :roleName")
	String getRoleNameByRoleId(@Param("roleName") String roleName);
	
	@Query("SELECT r.description from Role r WHERE r.roleId = :id")
	String getRoleIdByRoleName(@Param("id") Integer id);
	
	@Query("SELECT r from Role r where r.description = :name")
	Role findRoleByRoleName(@Param("name") String name);
	
	
}
