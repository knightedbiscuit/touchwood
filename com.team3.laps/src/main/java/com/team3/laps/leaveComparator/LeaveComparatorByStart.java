package com.team3.laps.leaveComparator;

import java.util.Comparator;

import com.team3.laps.model.Leave;

public class LeaveComparatorByStart implements Comparator<Leave>{

	@Override
	public int compare(Leave l1, Leave l2) {

		int result = 0;
		if(l1.getLeaveFrom().before(l2.getLeaveFrom())){
			result = 1;
		}
		if(l1.getLeaveFrom()==l2.getLeaveFrom()){
			result = 0;
		}
		if(l2.getLeaveFrom().before(l1.getLeaveFrom())){
			result = -1;
		}
		return result;
    }
}
