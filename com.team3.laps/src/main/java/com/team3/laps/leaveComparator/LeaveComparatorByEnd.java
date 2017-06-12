package com.team3.laps.leaveComparator;

import java.util.Comparator;

import com.team3.laps.model.Leave;


public class LeaveComparatorByEnd implements Comparator<Leave>{

	@Override
	public int compare(Leave l1, Leave l2) {

		int result = 0;
		if(l1.getLeaveTo().before(l2.getLeaveTo())){
			result = 1;
		}
		if(l1.getLeaveTo()==l2.getLeaveTo()){
			result = 0;
		}
		if(l2.getLeaveTo().before(l1.getLeaveTo())){
			result = -1;
		}
		return result;
    }
}