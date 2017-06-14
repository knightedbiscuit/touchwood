package com.team3.laps.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.team3.laps.repository.EmployeeRoleRepository;

@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService{

	@Resource
	private EmployeeRoleRepository erR;
	@Override
	@Transactional
	public String findRoleByeid(Integer eid) {
		// TODO Auto-generated method stub
		return erR.findRoleByeid(eid);
	}

	@Override
	@Transactional
	public String findRoleByename(String ename) {
		// TODO Auto-generated method stub
		return erR.findRoleByename(ename);
	}

}
