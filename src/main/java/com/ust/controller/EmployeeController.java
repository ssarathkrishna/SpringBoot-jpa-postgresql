package com.ust.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.model.Customer;
import com.ust.model.Employee;
import com.ust.service.EmployeeService;

@RestController()
@RequestMapping("/employee")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save")
	private String saveEmployee(@RequestBody Employee employee) {
		logger.info("inside save saveEmployee");
		employeeService.save(employee);
		return employee.getName() + " Saved Successfully";
	}

	@GetMapping("/getall")
	private List<Employee> getEmployees() {
		logger.info("inside getall getEmployees");
		return employeeService.findAll();
	}

	@PutMapping("/update")
	private String updateEmployee(@RequestBody Employee employee) {
		logger.info("inside update updateEmployee");
		employeeService.update(employee);
		return employee.getName() + " Updated Successfully";
	}

	@DeleteMapping("/delete")
	private String deleteEmployee(@RequestBody Employee employee) {
		logger.info("inside delete deleteEmployee");
		employeeService.delete(employee);
		return " deleted Successfully";
	}

	@GetMapping("/customers")
	private List<Customer> getCustomers() {
		logger.info("inside customers getCustomers");
		return employeeService.getCustomers();
	}

}
