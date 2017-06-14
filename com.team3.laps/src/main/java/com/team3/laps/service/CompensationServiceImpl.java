package com.team3.laps.service;

import java.util.ArrayList;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.team3.laps.model.Compensation;
import com.team3.laps.repository.CompensationRepository;

@Service
public class CompensationServiceImpl implements CompensationService{

	@Resource
	private CompensationRepository cr;
	@Override
	public ArrayList<Compensation> findAllCompensationsByStatus(String status) {
		// TODO Auto-generated method stub
		return cr.findAllCompensationsByStatus(status);
	}

	@Override
	@Transactional
	public ArrayList<Compensation> findCompensationsByStatusAndename(String status, String ename) {
		// TODO Auto-generated method stub
		return cr.findCompensationsByStatusAndename(status, ename);
	}

	@Override
	@Transactional
	public ArrayList<Compensation> findCompensationsByStatusAndeid(String status, Integer eid) {
		// TODO Auto-generated method stub
		return cr.findCompensationsByStatusAndeid(status, eid);
	}

}
