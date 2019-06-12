package com.sella.springboot.cruddemo.service;

import java.util.List;

import com.sella.springboot.cruddemo.entity.Employee;

public interface IEmployeeService {

	public List<Employee> getAllEmpDetails();
	public Employee getEmpbyId(final int empId);
	public List<Employee> findEmpDeptWise(final int deptNo);
}
