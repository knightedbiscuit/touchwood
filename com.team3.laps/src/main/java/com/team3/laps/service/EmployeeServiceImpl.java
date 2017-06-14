package com.team3.laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team3.laps.model.Compensation;
import com.team3.laps.model.Employee;
import com.team3.laps.model.Leave;
import com.team3.laps.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Resource
	private EmployeeRepository empRepository;

	@Override
	@Transactional
	public ArrayList<Employee> findSubordinatesByName(String Name) {
		
		return empRepository.findSubordinatesByName(Name);
	}

	@Override
	@Transactional
	public Employee findEmployeeByName(String ename) {
		
		return empRepository.findEmployeeByName(ename);
	}

	@Override
	@Transactional
	public ArrayList<Employee> findAllManagers() {
		
		return empRepository.findAllManagers();
	}

	@Override
	@Transactional
	public ArrayList<String> findAllManagerNames() {
		
		return empRepository.findAllManagerNames();
	}

	@Override
	@Transactional
	public ArrayList<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return (ArrayList<Employee>) empRepository.findAll();
	}

	@Override
	@Transactional
	public Employee findEmployee(Integer eid) {
		// TODO Auto-generated method stub
		return empRepository.findOne(eid);
	}

	@Override
	@Transactional
	public Employee createEmployee(Employee e) {
		// TODO Auto-generated method stub
		return empRepository.saveAndFlush(e);
	}

	@Override
	@Transactional
	public Employee changeEmployee(Employee e) {
		// TODO Auto-generated method stub
		return empRepository.saveAndFlush(e);
	}

	@Override
	@Transactional
	public void removeEmployee(Employee e) {
		// TODO Auto-generated method stub
		empRepository.delete(e);
	}

	@Override
	@Transactional
	public Employee findEmployeeLogin(String loginname, String pwd) {
		// TODO Auto-generated method stub
		return empRepository.findEmployeeLogin(loginname, pwd);
	}

	@Override
	@Transactional
	public ArrayList<String> findAllEmployeeids() {
		// TODO Auto-generated method stub
		return empRepository.findAllEmployeeids();
	}

	@Override
	public void addEmployee(Employee e) {
		// TODO Auto-generated method stub
		empRepository.saveAndFlush(e);
	}

	@Override
	@Transactional
	public ArrayList<Compensation> findCompensationsByeid(Integer eid) {
		// TODO Auto-generated method stub
		return empRepository.findCompensationsByeid(eid);
	}

	@Override
	@Transactional
	public ArrayList<Leave> findLeavesByeid(Integer eid) {
		// TODO Auto-generated method stub
		return empRepository.findLeavesByeid(eid);
	}

}
