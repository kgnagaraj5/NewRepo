package com.sella.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sella.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a native query
		Query<Employee> theQuery =
				currentSession.createQuery("from Employee", Employee.class);
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return the results		
		return employees;
	}
	
	@Override
	public List<Employee> findEmpDeptWise(final int deptNo){
		
		//Get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//Create a native Query
		Query<Employee> nativeQuery = currentSession.createQuery("from Employee where departmentId = :deptNo",Employee.class);
		nativeQuery.setParameter("deptNo", deptNo);
		//Execute query and get Department wise Employee List
		List<Employee> employees = nativeQuery.getResultList();
		
		return employees;
	}


	@Override
	public Employee getEmployee(int empId) {
		
		//To get current Hibernate Session
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee = currentSession.get(Employee.class, empId);
		
		return employee;
	}
	
	

}







