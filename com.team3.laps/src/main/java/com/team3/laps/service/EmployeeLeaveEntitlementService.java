package com.team3.laps.service;

import java.util.ArrayList;
import com.team3.laps.model.EmployeeLeaveEntitlement;

public interface EmployeeLeaveEntitlementService {
	
	ArrayList<EmployeeLeaveEntitlement> findLeaveEntitlementsByLeaveType(String ltype);
	ArrayList<EmployeeLeaveEntitlement> findLeaveEntitlementsByRolename(String rname);
}
