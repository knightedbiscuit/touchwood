package com.team3.laps.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team3.laps.model.Employee;
import com.team3.laps.service.EmployeeService;

@Controller
@RequestMapping(value = "/home")
public class CommonControllor {

	@Autowired
	private EmployeeService eService;
	
	@RequestMapping(value="/start", method = RequestMethod.GET)
	public ModelAndView showStartpage()
	{
		return new ModelAndView("start");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login", "employee", new Employee());
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute Employee employee, BindingResult results, HttpSession session) {
		ModelAndView mv = new ModelAndView("apply-annualleave");

		if (results.hasErrors())
			return mv;

		if (employee.getName() == null && employee.getPassword() == null) {
			return mv;
		} else {
			String inputE = "x";
			String inputP = "y";

			inputE = employee.getName();
			inputP = employee.getPassword();

			mv = new ModelAndView("start", "name", inputE);
			return mv;
		}

//		 UserSession us = new UserSession();
//		
//		 if (employee.getName() != null && employee.getPassword() != null) {
//		 Employee e = eService.authenticate(employee.getName(),
//		 employee.getPassword());
//		 us.setEmployee(e);
//		 us.setSessionId(session.getId());
//		 session.setAttribute("USERSESSION", us);
//		 mv = new ModelAndView("start");
//		 return mv;
//		 } else {
//		 return mv;
//		 }

	}

}
