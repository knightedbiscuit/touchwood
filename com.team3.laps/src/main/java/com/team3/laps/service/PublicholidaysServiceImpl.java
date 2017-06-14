package com.team3.laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.team3.laps.model.Publicholidays;
import com.team3.laps.repository.PublicholidaysRepository;

@Service
public class PublicholidaysServiceImpl implements PublicholidaysService{

	@Resource
	private PublicholidaysRepository pdR;
	
	@Override
	@Transactional
	public ArrayList<Publicholidays> findAllPublicholiday() {
		// TODO Auto-generated method stub
		return (ArrayList<Publicholidays>) pdR.findAll();
	}

	@Override
	@Transactional
	public Publicholidays findPublicholiday(String pdid) {
		// TODO Auto-generated method stub
		return pdR.findOne(pdid);
	}

	@Override
	@Transactional
	public Publicholidays createPublicholiday(Publicholidays publicholiday) {
		// TODO Auto-generated method stub
		return pdR.saveAndFlush(publicholiday);
	}

	@Override
	@Transactional
	public Publicholidays changePublicholiday(Publicholidays publicholiday) {
		// TODO Auto-generated method stub
		return pdR.saveAndFlush(publicholiday);
	}

	@Override
	@Transactional
	public void removePublicholiday(Publicholidays publicholiday) {
		// TODO Auto-generated method stub
		pdR.delete(publicholiday);
	}
}
