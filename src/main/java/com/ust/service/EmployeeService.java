package com.ust.service;

import java.util.List;

import com.ust.model.Customer;
import com.ust.model.Employee;

public interface EmployeeService {

	void save(Employee employee);

	List<Employee> findAll();

	void update(Employee employee);

	void delete(Employee employee);

	List<Customer> getCustomers();

}
