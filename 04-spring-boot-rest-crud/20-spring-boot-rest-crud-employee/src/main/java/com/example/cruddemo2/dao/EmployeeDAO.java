package com.example.cruddemo2.dao;

import java.util.List;

import com.example.cruddemo2.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();

	Employee findById(int theId);

	Employee save(Employee theEmployee);

	void deleteById(int theId);
}