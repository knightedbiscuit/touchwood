package com.team3.laps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team3.laps.model.PublicHolidays;


public interface PublicHolidaysRepository extends JpaRepository<PublicHolidays,String> {

}
