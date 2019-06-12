package com.sella.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sella.springboot.cruddemo.entity.Employee;
import com.sella.springboot.cruddemo.service.IEmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private IEmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// expose "/employees" and return list of employees
	@RequestMapping(value = "/employees",method = RequestMethod.GET,produces = "application/xml")
	public List<Employee> findAll() {
		return employeeService.getAllEmpDetails();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		return employeeService.getEmpbyId(employeeId);
	}
	
	@GetMapping("/employees/deptwise/{departmentId}")
	public List<Employee> findEmpDeptWise(@PathVariable int departmentId){
		return employeeService.findEmpDeptWise(departmentId);
	}
}










