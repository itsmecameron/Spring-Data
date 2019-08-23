package com.springdata.studentroster.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springdata.studentroster.models.Course;
import com.springdata.studentroster.services.CourseService;

@Controller
@RequestMapping("/courses")

public class CourseContoller {
	@Autowired
	CourseService courseServ;
	
	@GetMapping("/new")
	public String index(Model model) {
		model.addAttribute("newCourse", new Course());
		return "courses/new.jsp";
	}
	
	@PostMapping("/process")
	public String create(@Valid @ModelAttribute("newCourse") Course course, BindingResult result) {
		if (result.hasErrors()) {
			return "courses/new.jsp";
		} else {
			courseServ.createCourse(course);
			return "redirect:/students";
		}
	}
}
