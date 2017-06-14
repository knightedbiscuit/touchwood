package com.team3.laps.service;

import java.util.ArrayList;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.team3.laps.model.EmployeeLeaveEntitlement;
import com.team3.laps.repository.EmployeeLeaveEntitlementRepository;
@Service
public class EmployeeLeaveEntitlementServiceImpl implements EmployeeLeaveEntitlementService{

	@Resource
	private EmployeeLeaveEntitlementRepository empES;
	@Override
	@Transactional
	public ArrayList<EmployeeLeaveEntitlement> findLeaveEntitlementsByLeaveType(String ltype) {
		
		return empES.findLeaveEntitlementsByLeaveType(ltype);
	}

	@Override
	@Transactional
	public ArrayList<EmployeeLeaveEntitlement> findLeaveEntitlementsByRolename(String rname) {
		
		return empES.findLeaveEntitlementsByRolename(rname);
	}

}
