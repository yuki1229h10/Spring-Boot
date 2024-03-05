package com.example.cruddemo2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cruddemo2.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!

}
