package com.tyss.ems_springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tyss.ems_springmvc.dto.Employee;
import com.tyss.ems_springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@RequestMapping("/userapp")
	public ModelAndView landingPage() {
		ModelAndView view = new ModelAndView("registerEmployee.jsp");
		view.addObject("employee", new Employee());
		return view;
	}

	/*
	 * @ModelAttribute is used to inform that we are getting object from jsp
	 */
	@RequestMapping("/saveemployee")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {

		System.out.println(employee);

		boolean emp = service.saveEmployee(employee);

		ModelAndView mav = new ModelAndView("dashboard.jsp");

		if (emp) {

			return getAllEmployee();
		} else
			mav.addObject("msg", "Employee is not saved..");
		return mav;

	}

	@RequestMapping("/findall")
	public ModelAndView getAllEmployee() {

		List<Employee> employeeList = service.findAllEmployee();

		ModelAndView mav = new ModelAndView("display.jsp");

		mav.addObject("employeeList", employeeList);

		return mav;
	}

	@RequestMapping("/edit")
	public ModelAndView editEmployee(int id) {
		Employee upUser = service.findEmployee(id);
		ModelAndView mav = new ModelAndView("edit.jsp");
		mav.addObject("updateEmployee", upUser);
		return mav;
	}

	@RequestMapping("/saveEditEmp")
	public ModelAndView saveUpdatedUser(@ModelAttribute Employee employee) {
		service.updateEmployee(employee);
		return getAllEmployee();
	}

	@RequestMapping("/delete")
	public ModelAndView deleteEmployee(@RequestParam int id) {
		service.findEmployee(id);
		return getAllEmployee();
	}

}
