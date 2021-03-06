package com.team3.laps.service;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team3.laps.repository.EmployeeRepository;

import com.team3.laps.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Resource
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional
	public Employee findEmployeeById(int i) {
		return employeeRepository.findEmployeeById(i);
	}
	
	@Override
	@Transactional
	public Employee authenticate(String username, String password)
	{
		return employeeRepository.findEmployeeByNamePwd(username, password);
	}
	
}
