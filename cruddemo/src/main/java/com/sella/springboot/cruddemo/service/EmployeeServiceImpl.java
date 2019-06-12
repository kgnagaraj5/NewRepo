package com.sella.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sella.springboot.cruddemo.dao.EmployeeDAO;
import com.sella.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	private EmployeeDAO employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public List<Employee> getAllEmpDetails() {		
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee getEmpbyId(int empId) {
		Employee employee =  employeeDao.getEmployee(empId);
		if(employee == null) {
			throw new RuntimeException("Employee Not Found");
		}
		
		return employee;
	}

	@Override
	@Transactional
	public List<Employee> findEmpDeptWise(final int deptNo) {
		List<Employee> empList = employeeDao.findEmpDeptWise(deptNo);
		if(empList.isEmpty()) {
			throw new RuntimeException("Employees Not Found for the particular department");
		}
		return empList;
	}

}
