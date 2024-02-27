package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// define end point for "/students" - return a list of students

	@GetMapping("/students")
	public List<Student> getStudents() {

		List<Student> theStudents = new ArrayList<>();

		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));

		return theStudents;
	}
}
