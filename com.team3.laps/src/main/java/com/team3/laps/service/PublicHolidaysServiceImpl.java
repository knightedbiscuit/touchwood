package com.team3.laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team3.laps.model.PublicHolidays;
import com.team3.laps.repository.PublicHolidaysRepository;

@Service
public class PublicHolidaysServiceImpl implements PublicHolidaysService {

	@Resource
	PublicHolidaysRepository pbRepo;
	
	@Transactional
	@Override
	public ArrayList<PublicHolidays> findAllHolidays() {
		return (ArrayList<PublicHolidays>)pbRepo.findAll();

	}

}
