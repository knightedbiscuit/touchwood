package com.team3.laps.service;

import java.util.ArrayList;
import com.team3.laps.model.Compensation;

public interface CompensationService {
	
	ArrayList<Compensation> findAllCompensationsByStatus(String status);	
	
	ArrayList<Compensation> findCompensationsByStatusAndename(String status,String ename);
	
	ArrayList<Compensation> findCompensationsByStatusAndeid(String status, Integer eid);
}
