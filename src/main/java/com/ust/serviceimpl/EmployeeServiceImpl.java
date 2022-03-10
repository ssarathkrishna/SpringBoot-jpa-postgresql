package com.ust.serviceimpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.ust.model.Customer;
import com.ust.model.Employee;
import com.ust.repository.EmployeeRepository;
import com.ust.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final String CUSTOMERS = "/customer/getAll";

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	private RestTemplateBuilder restTemplate;

	@Value("${springmvc.url}")
	private String mvcURL;

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);

	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);

	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(employee.getId());
	}

	@Override
	public List<Customer> getCustomers() {

		Customer[] Customer = restTemplate.build().getForObject(mvcURL + CUSTOMERS, Customer[].class);
		return Arrays.asList(Customer);
	}

}
