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

		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "leave_from", "From date is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "leave_to", "To date is required.");

		if ((leave.getLeave_from() != null && leave.getLeave_to() != null)
				&& (leave.getLeave_from().after(leave.getLeave_to()))) {
			arg1.reject("leave_from", "End date should be greater than start date");
			arg1.rejectValue("leave_from", "to date must be > from date");
		}

		if (leave.getLeave_from() != null && leave.getLeave_to() != null) {
			Calendar calTo = Calendar.getInstance();
			Calendar calFrom = Calendar.getInstance();
			calTo.setTime(leave.getLeave_to());
			calFrom.setTime(leave.getLeave_from());

			if (calTo.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| calTo.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				arg1.rejectValue("leave_to", "To date must be a working day");
			}

			if (calFrom.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| calFrom.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				arg1.rejectValue("leave_from", "From date must be a working day");
			}
		}

	}
}
