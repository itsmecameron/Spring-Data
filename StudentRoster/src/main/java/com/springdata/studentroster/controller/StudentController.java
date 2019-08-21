package com.springdata.studentroster.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springdata.studentroster.models.Student;
import com.springdata.studentroster.services.StudentServices;

@Controller
public class StudentController {
	@Autowired
	StudentServices studentServ;
	
	@GetMapping("/students")
	public String home(Model model, @ModelAttribute("newStudent") Student student) {
		List<Student> allStudents = studentServ.allStudents();
		model.addAttribute("students", allStudents);
		return "student/index.jsp";
	}
	
	@GetMapping("/students/new")
	public String newSong(Model model) {
		model.addAttribute("newStudent", new Student());
		return "student/new.jsp";
	}
	
	@PostMapping("/students/process")
    public String createStudent (@Valid @ModelAttribute("newStudentt") Student student, BindingResult results) {
		if(results.hasErrors()) {
			return "student/new.jsp";
		}
		studentServ.createOrUpdateStudent(student);
		System.out.println(student.getFirst_name());
		return "redirect:/students";
    }
}
