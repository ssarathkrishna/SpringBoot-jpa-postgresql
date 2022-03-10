package com.ust.controller;

import java.util.List;

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

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save")
	private String saveEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee.getName() + " Saved Successfully";
	}

	@GetMapping("/getall")
	private List<Employee> getEmployees() {
		return employeeService.findAll();
	}

	@PutMapping("/update")
	private String update(@RequestBody Employee employee) {
		employeeService.update(employee);
		return employee.getName() + " Updated Successfully";
	}

	@DeleteMapping("/delete")
	private String delete(@RequestBody Employee employee) {
		employeeService.delete(employee);
		return " deleted Successfully";
	}
	
	@GetMapping("/customers")
	private List<Customer> getCustomers() {
		return employeeService.getCustomers();
	}
	

}
