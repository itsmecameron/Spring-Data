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
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdata.studentroster.models.Student;
import com.springdata.studentroster.services.ContactServices;
import com.springdata.studentroster.services.StudentServices;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	StudentServices studentServ;
	@Autowired 
	ContactServices contactServ;
	
	@GetMapping("")
	public String home(Model model, @ModelAttribute("newStudent") Student student) {
		List<Student> allStudents = studentServ.allStudents();
		model.addAttribute("students", allStudents);
		return "student/index.jsp";
	}
	
	@GetMapping("/new")
	public String newSong(Model model) {
		model.addAttribute("newStudent", new Student());
		return "student/new.jsp";
	}
	
	@PostMapping("/process")
    public String createStudent (@Valid @ModelAttribute("newStudent") Student student, BindingResult results) {
		if(results.hasErrors()) {
			return "student/new.jsp";
		}
		studentServ.createOrUpdateStudent(student);
		System.out.println(student.getFirst_name());
		return "redirect:/students";
    }
}
