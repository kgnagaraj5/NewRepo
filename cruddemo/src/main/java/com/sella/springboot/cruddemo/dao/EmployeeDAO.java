package com.sella.springboot.cruddemo.dao;

import java.util.List;

import com.sella.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
		
}
