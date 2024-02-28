package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

	// define @PostConstruct to load the student data ... only once!

	@PostConstruct
	public void loadData() {

		theStudents = new ArrayList<>();

		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));
	}

	// define end point for "/students" - return a list of students

	@GetMapping("/students")
	public List<Student> getStudents() {

		return theStudents;
	}
}
