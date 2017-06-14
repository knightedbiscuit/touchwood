package com.team3.laps.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
import com.team3.laps.model.Employee;
import com.team3.laps.model.EmployeeLeaveTracker;
import com.team3.laps.model.Leave;
import com.team3.laps.model.LeaveType;
import com.team3.laps.model.Publicholidays;
import com.team3.laps.service.EmployeeLeaveTrackerService;
import com.team3.laps.service.EmployeeService;
import com.team3.laps.service.LeaveService;
import com.team3.laps.service.LeaveTypeService;
import com.team3.laps.service.PublicholidaysService;
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
	private EmployeeService eService;

	@Autowired
	private EmployeeLeaveTrackerService eTrackerService;

	@Autowired
	private PublicholidaysService phService;

	public static long findDayDifference(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;
	}

	@RequestMapping(value = "/annual", method = RequestMethod.GET)
	public ModelAndView createAnnualLeavePage(Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView("apply-annualleave");
		Leave leave = new Leave();
		leave.setStatus("New");
		mav.addObject("leave", leave);
		mav.addObject("leavetype", "ANNUAL LEAVE");

		Employee e = eService.findEmployee(2);
		Integer managerID = e.getManagerId();
		if (managerID != null) {
			String managerName = eService.findEmployee(managerID).getName();
			session.setAttribute("managerName", managerName);
			return mav;
		} else {
			session.setAttribute("managerName", "None");
			return mav;
		}

	}

	@RequestMapping(value = "/medical", method = RequestMethod.GET)
	public ModelAndView createMedicalLeavePage(Model model, HttpSession session) {
		ModelAndView mav = new ModelAndView("apply-medicalleave");
		Leave leave = new Leave();
		leave.setStatus("New");
		mav.addObject("leave", leave);
		mav.addObject("leavetype", "MEDICAL LEAVE");

		Employee e = eService.findEmployee(1);
		Integer managerID = e.getManagerId();
		if (managerID != null) {
			String managerName = eService.findEmployee(managerID).getName();
			session.setAttribute("managerName", managerName);
			return mav;
		} else {
			session.setAttribute("managerName", "None");
			return mav;
		}

	}

	// @RequestMapping(value = "/annual", params = "calculate")
	// public ModelAndView calculateLeave(@ModelAttribute Leave leave,
	// BindingResult result, HttpSession session) {
	//
	// ModelAndView mv = new ModelAndView("apply-annualleave");
	// leaveValidator.validate(leave, result);
	// if (result.hasErrors()) {
	// return mv;
	// }
	//
	// return mv;
	// }

	@RequestMapping(value = "/annual", params = "submit", method = RequestMethod.POST)
	public ModelAndView submitAnnualLeave(@ModelAttribute Leave leave, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpSession session) {
		/* validate empty field, date */
		leaveValidator.validate(leave, result);
		if (result.hasErrors()) {
			return new ModelAndView("apply-annualleave");
		}

		/* check for overlapping leave */
		ArrayList<Leave> leaveList = lService.findLeavesByTypeID(ANNUAL_LEAVEID);
		for(Leave l:leaveList)
		{
			if(leave.getLeaveFrom().before(l.getLeaveTo())&&l.getLeaveFrom().after(leave.getLeaveTo()))
			{
				ModelAndView mav = new ModelAndView("apply-annualleave");
				mav.addObject("errorMsg", "You have Applied/Approved leave during this period");
				return mav;
			}
		}

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
		while (calFrom.before(calTo)) {
			if (calFrom.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| calFrom.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				satsunCount++;
			} else {
				ArrayList<Publicholidays> phList = phService.findAllPublicholiday();
				for (Publicholidays ph : phList) {
					if (calFrom.getTime().equals(ph.getDateFrom()) || calFrom.getTime().equals(ph.getDateTo())) {
						weekdayPbCount++;
					}
				}
			}

			calFrom.add(Calendar.DATE, 1);
		}

		/* Compute actual leave taken */
		if (findDayDifference(dateFrom, dateTo) <= 14) {
			leaveCount = (double) findDayDifference(dateFrom, dateTo) - satsunCount - weekdayPbCount;
		} else {
			leaveCount = (double) findDayDifference(dateFrom, dateTo) - weekdayPbCount;
		}

		/* Deny application if exceed leave balance */
		// UserSession us = (UserSession)session.getAttribute("USERSESSION");
		// int id = us.getEmployee().getEmployeeId();

		
		Integer eID = 9;
		double leaveleft = eTrackerService.findAvailableleave(eID, ANNUAL_LEAVEID);

		if (leaveCount > leaveleft) {
			ModelAndView mv2 = new ModelAndView("apply-annualleave", "leave", leave);
			mv2.addObject("errorMsg", "Leave applied exceed leave available");
			return mv2;
		} else {

			leave.setEmployeeId(2);
			leave.setLeaveTypeId(ANNUAL_LEAVEID);
			leave.setAppliedOn(new Date());
			leave.setStatus(STATUS);
			lService.addLeave(leave);

			EmployeeLeaveTracker eLT = eTrackerService.findEmployeeTracker(eID, ANNUAL_LEAVEID);
			eLT.setDays(leaveleft - leaveCount);
			eTrackerService.updateAvailableLeave(eLT);
			
			/*Format date for display*/
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");		
		
			/* redirect to successful submission page */
			ModelAndView mv = new ModelAndView("redirect:/applyleave/success");
			redirectAttributes.addFlashAttribute("leavefrom", df.format(leave.getLeaveFrom()));
			redirectAttributes.addFlashAttribute("leaveto", df.format(leave.getLeaveTo()));
			redirectAttributes.addFlashAttribute("leavetype", "Annual");
			redirectAttributes.addFlashAttribute("leavecount", leaveCount);
			redirectAttributes.addFlashAttribute("leave", leave);
			redirectAttributes.addFlashAttribute("message", "Successful Leave Submission");

			return mv;
		}

	}

	@RequestMapping(value = "/medical", params = "submit", method = RequestMethod.POST)
	public ModelAndView submitMedicalLeave(@ModelAttribute Leave leave, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpSession session) {
		/* validate empty field, date */
		leaveValidator.validate(leave, result);
		if (result.hasErrors()) {
			return new ModelAndView("apply-medicalleave");
		}

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
		while (calFrom.before(calTo)) {
			if (calFrom.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
					|| calFrom.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				satsunCount++;
			} else {
				ArrayList<Publicholidays> phList = phService.findAllPublicholiday();
				for (Publicholidays ph : phList) {
					if (calFrom.getTime().equals(ph.getDateFrom()) || calFrom.getTime().equals(ph.getDateTo())) {
						weekdayPbCount++;
					}
				}
			}

			calFrom.add(Calendar.DATE, 1);
		}

		/* Compute actual leave taken */
		leaveCount = (double) findDayDifference(dateFrom, dateTo) - satsunCount - weekdayPbCount;

		Integer eID = 9;
		double leaveleft = eTrackerService.findAvailableleave(eID, MEDICAL_LEAVEID);

		if (leaveCount > leaveleft) {
			ModelAndView mv2 = new ModelAndView("apply-medicalleave", "leave", leave);
			mv2.addObject("errorMsg", "Leave applied exceed leave available");
			return mv2;
		} else {

			leave.setEmployeeId(2);
			leave.setLeaveTypeId(MEDICAL_LEAVEID);
			leave.setAppliedOn(new Date());
			leave.setStatus(STATUS);
			lService.addLeave(leave);

			EmployeeLeaveTracker eLT = eTrackerService.findEmployeeTracker(eID, MEDICAL_LEAVEID);
			eLT.setDays(leaveleft - leaveCount);
			eTrackerService.updateAvailableLeave(eLT);
			
			/*Format date for display*/
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");		

			/* redirect to successful submission page */
			ModelAndView mv = new ModelAndView("redirect:/applyleave/success");
			redirectAttributes.addFlashAttribute("leavefrom", df.format(leave.getLeaveFrom()));
			redirectAttributes.addFlashAttribute("leaveto", df.format(leave.getLeaveTo()));
			redirectAttributes.addFlashAttribute("leavetype", "Medical Leave");
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
