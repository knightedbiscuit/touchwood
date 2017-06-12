package com.team3.laps.validator;

import java.util.Calendar;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.team3.laps.model.Leave;

@Component
public class LeaveValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Leave.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Leave leave = (Leave) arg0;

		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "leaveFrom", "From date is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "leaveTo", "To date is required.");

		if ((leave.getLeaveFrom() != null && leave.getLeaveTo() != null)
				&& (leave.getLeaveFrom().after(leave.getLeaveTo()))) {
			arg1.reject("leaveFrom", "End date should be greater than start date");
			arg1.rejectValue("leaveFrom", "to date must be > from date");
		}

		if (leave.getLeaveFrom() != null && leave.getLeaveTo() != null) {
			Calendar calTo = Calendar.getInstance();
			Calendar calFrom = Calendar.getInstance();
			calTo.setTime(leave.getLeaveTo());
			calFrom.setTime(leave.getLeaveFrom());

			if (calTo.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| calTo.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				arg1.rejectValue("leaveTo", "To date must be a working day");
			}

			if (calFrom.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| calFrom.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				arg1.rejectValue("leaveFrom", "From date must be a working day");
			}
		}

	}
}
