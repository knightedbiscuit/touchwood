package com.team3.laps.service;

import java.util.ArrayList;
import com.team3.laps.model.Publicholidays;

public interface PublicholidaysService {

	ArrayList<Publicholidays> findAllPublicholiday();

	Publicholidays findPublicholiday(String pdid);

	Publicholidays createPublicholiday(Publicholidays publicholiday);

	Publicholidays changePublicholiday(Publicholidays publicholiday);

	void removePublicholiday(Publicholidays publicholiday);
}
