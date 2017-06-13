package com.team3.laps.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.team3.laps.model.LeaveType;
import com.team3.laps.model.PublicHolidays;
import com.team3.laps.service.EmployeeLeaveTrackerService;
import com.team3.laps.service.LeaveService;
import com.team3.laps.service.LeaveTypeService;
import com.team3.laps.service.PublicHolidaysService;
import com.team3.laps.validator.LeaveValidator;

@Controller
@RequestMapping(value = "/applyleave")
public class ApplyLeaveControllor {

	private static final Integer ANNUAL_LEAVEID = 1;
	private static final Integer MEDICAL_LEAVEID = 2;
	private static final String STATUS = "applied";

	@Autowired
	private LeaveService lService;

	@Autowired
	private LeaveValidator leaveValidator;

	@Autowired
	private EmployeeLeaveTrackerService eTrackerService;

	@Autowired
	private PublicHolidaysService phService;

	public static long findDayDifference(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;
	}

	@RequestMapping(value = "/annual", method = RequestMethod.GET)
	public ModelAndView createAnnualLeavePage(Model model, HttpSession session) {
		Leave leave = new Leave();
		leave.setStatus("New");
		return new ModelAndView("apply-annualleave", "leave", leave);

	}

	@RequestMapping(value = "/annual", params = "submit", method = RequestMethod.POST)
	public ModelAndView submitAnnualLeave(@ModelAttribute Leave leave, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpSession session) {
		/* validate empty field, date, Workingday */
		leaveValidator.validate(leave, result);
		if (result.hasErrors()) {
			return new ModelAndView("apply-annualleave");
		}

		/* check for overlapping leave */
//		if(lService.checkLeavebtwPeriod(leave.getLeaveFrom(), leave.getLeaveTo()))
//		{
//			ModelAndView mav = new ModelAndView("apply-annualleave");
//			mav.addObject("error", "You have already applied for leave during this period");
//		}

		Date dateFrom = leave.getLeaveFrom();
		Date dateTo = leave.getLeaveTo();

		/* calculate leave taken */
		Calendar calFrom = Calendar.getInstance();
		Calendar calTo = Calendar.getInstance();
		calFrom.setTime(dateFrom);
		calTo.setTime(dateTo);

		/* check for weekends and public holiday during the leave period */
		double leaveCount = 0;

		double satsunCount = 0;
		double weekdayPbCount = 0;
		calTo.add(Calendar.DATE, 1);
		while (calFrom.before(calTo)) 
		{
			if (calFrom.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| calFrom.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				satsunCount++;
			} else {
				ArrayList<PublicHolidays> phList = phService.findAllHolidays();
				for (PublicHolidays ph : phList) {
					if (calFrom.getTime().equals(ph.getDateFrom()) || calFrom.getTime().equals(ph.getDateTo())) {
						weekdayPbCount++;
					}
				}
			}

			calFrom.add(Calendar.DATE, 1);
		}
		
		/* Compute actual leave take*/
		if (findDayDifference(dateFrom, dateTo) <= 14) {
			leaveCount = (double) findDayDifference(dateFrom, dateTo) - satsunCount - weekdayPbCount;
		} else {
			leaveCount = (double) findDayDifference(dateFrom, dateTo) - weekdayPbCount;
		}

		/* Deny application if exceed leave balance */
		// UserSession us = (UserSession)session.getAttribute("USERSESSION");
		// int id = us.getEmployee().getEmployeeId();
		// Integer eID = 9;
		// double leaveleft = eTrackerService.findAvailableLeave(eID,
		// ANNUAL_LEAVEID);
		if (leaveCount > 5) {
			ModelAndView mv2 = new ModelAndView("apply-annualleave", "leave", leave);
			mv2.addObject("errorMsg", "Leave applied exceed leave available");
			return mv2;
		} else {
			leave.setEmployeeId(2);
			leave.setLeaveTypeId(ANNUAL_LEAVEID);
			leave.setAppliedOn(new Date());
			leave.setStatus(STATUS);
			leave.setComments("no comments");
			lService.addLeave(leave);

			/* redirect to successful submission page */
			ModelAndView mv = new ModelAndView("redirect:/applyleave/success");
			redirectAttributes.addFlashAttribute("leavetype", "Annual");
			redirectAttributes.addFlashAttribute("leavecount", leaveCount);
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
