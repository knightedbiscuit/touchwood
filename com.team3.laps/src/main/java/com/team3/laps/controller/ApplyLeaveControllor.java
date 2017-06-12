package com.team3.laps.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team3.laps.javaBean.UserSession;
import com.team3.laps.model.Leave;
import com.team3.laps.service.EmployeeLeaveTrackerService;
import com.team3.laps.service.LeaveService;
import com.team3.laps.validator.LeaveValidator;

@Controller
@RequestMapping(value = "/applyleave")
public class ApplyLeaveControllor {

	private static final Integer ANNUAL_LEAVEID = 1;
	private static final int MEDICAL_LEAVEID = 2;

	@Autowired
	private LeaveService lService;

	@Autowired
	private LeaveValidator leaveValidator;

	@Autowired
	private EmployeeLeaveTrackerService eTrackerService;

	public static long findDayDifference(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;
	}

	@RequestMapping(value = "/annual", method = RequestMethod.GET)
	public ModelAndView createAnnualLeavePage(Model model, HttpSession session) {
		return new ModelAndView("apply-annualleave", "leave", new Leave());

	}

	@RequestMapping(value = "/annual", params = "submit", method = RequestMethod.POST)
	public ModelAndView submitAnnualLeave(@ModelAttribute Leave leave, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpSession session) {
		/*validate empty field, date, Workingday*/
		leaveValidator.validate(leave, result);

		if (result.hasErrors()) {
			return new ModelAndView("apply-annualleave");
		}
		
		/*check for overlapping leave*/

		Date dateFrom = leave.getLeaveFrom();
		Date dateTo = leave.getLeaveTo();

		/* calculate leave taken */
		Calendar calFrom = Calendar.getInstance();
		Calendar calTo = Calendar.getInstance();
		calFrom.setTime(dateFrom);
		calTo.setTime(dateTo);
		
		/* calculate leave taken : >14days, include Sat,Sun and vice versa */
		double count = 0;
		if (findDayDifference(dateFrom, dateTo) <= 14) {
			int satSun = 0;
			calTo.add(Calendar.DATE, 1);
			while (calFrom.before(calTo)) {
				if (calFrom.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
						|| calFrom.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
					satSun++;
				}
				calFrom.add(Calendar.DATE, 1);
			}
			count = (double) findDayDifference(dateFrom, dateTo) - satSun;
		} else {
			count = (double) findDayDifference(dateFrom, dateTo);
		}

		/* Deny application if exceed leave balance */
		// UserSession us = (UserSession)session.getAttribute("USERSESSION");
		// int id = us.getEmployee().getEmployeeId();
		Integer eID = 9;
		double leaveleft = eTrackerService.findAvailableLeave(eID, ANNUAL_LEAVEID);
		if (count > leaveleft) {
			return new ModelAndView("apply-annualleave");
		}
		else{
			// Date myDate = new Date();
			// java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
			leave.setStatus("Applied");
			leave.setComments("no comments");
			// lService.addLeave(leave);

			/* redirect to successful submission page */
			ModelAndView mv = new ModelAndView("redirect:/applyleave/success");

			redirectAttributes.addFlashAttribute("leavetype", "Annual");
			redirectAttributes.addFlashAttribute("leavecount", count);
			redirectAttributes.addFlashAttribute("leave", leave);
			redirectAttributes.addFlashAttribute("message", "Successful Leave Submission.");

			return mv;
		}


	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView showSuccessMsg() {
		return new ModelAndView("leave-success");
	}

	@RequestMapping(value = "/medical")
	public String applyMedicalLeave(Model model, HttpSession session) {

		return "apply-medicalleave";
	}
}
