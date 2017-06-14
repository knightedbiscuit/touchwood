package com.team3.laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team3.laps.model.Role;
import com.team3.laps.repository.RoleRepository;
@Service
public class RoleServiceImpl implements RoleService{

	@Resource
	private RoleRepository rR;
	
	@Override
	@Transactional
	public ArrayList<Role> findAllRoles() {
		// TODO Auto-generated method stub
		return (ArrayList<Role>) rR.findAll();
	}

	@Override
	@Transactional
	public Role findRole(Integer id) {
		// TODO Auto-generated method stub
		return rR.findOne(id);
	}

	@Override
	@Transactional
	public Role createRole(Role r) {
		// TODO Auto-generated method stub
		return rR.saveAndFlush(r);
	}

	@Override
	@Transactional
	public Role changeRole(Role r) {
		// TODO Auto-generated method stub
		return rR.saveAndFlush(r);
	}

	@Override
	public void removeRole(Role r) {
		// TODO Auto-generated method stub
		rR.delete(r);
	}

}
