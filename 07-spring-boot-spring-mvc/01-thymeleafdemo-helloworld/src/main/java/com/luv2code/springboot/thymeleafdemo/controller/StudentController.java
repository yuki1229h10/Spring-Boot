package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.luv2code.springboot.thymeleafdemo.model.Student;

@Controller
public class StudentController {

	@GetMapping("/showStudentForm")
	public String showForm(Model theModel) {

		// create a student object
		Student theStudent = new Student();

		// add student object to the model
		theModel.addAttribute("student", theStudent);

		return "student-form";
	}
}
