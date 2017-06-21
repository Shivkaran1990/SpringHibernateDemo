package com.controllers;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hibernate.entity.EmployeeEntity;
import com.interfaces.EmployeeManager;

@Controller
public class EditEmployeeController {
	
	@Autowired
	private EmployeeManager employeeManager;
	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listEmployees(ModelMap map) {
		map.addAttribute("employee", new EmployeeEntity());
		map.addAttribute("employeeList", employeeManager.getAllEmployees());
		return "editEmployeeList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(
			@ModelAttribute(value = "employee") EmployeeEntity employee,
			BindingResult result, String customerInfo, ModelMap map)
			throws JsonParseException, JsonMappingException, IOException {
		/*
		 * ObjectMapper mapper = new ObjectMapper(); EmployeeEntity emp =
		 * mapper.readValue(customerInfo, EmployeeEntity.class);
		 */
		employeeManager.addEmployee(employee);
		return "redirect:/";
	}

	@RequestMapping("/delete/{employeeId}")
	public String deleteEmplyee(@PathVariable("employeeId") String employeeId,
			ModelMap map) {
		Integer empID = Integer.parseInt(employeeId);
		employeeManager.deleteEmployee(empID);
		return "redirect:/";
	}



	@RequestMapping("/update/{employeeId}")
	public String updateEmp(
			@ModelAttribute(value = "employee") EmployeeEntity employee,
			BindingResult result,
			@PathVariable("employeeId") String employeeId, String customerInfo,
			ModelMap map) {
		
		Integer empID = Integer.parseInt(employeeId);
		employee.setId(empID);
		employeeManager.updateEmployee(empID, employee);

		return "redirect:/";
	}

}
