package com.springdata.studentroster.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springdata.studentroster.models.Dorm;
import com.springdata.studentroster.models.Student;
import com.springdata.studentroster.services.DormServices;
import com.springdata.studentroster.services.StudentServices;

@Controller
@RequestMapping("/dorms")
public class DormController {
	@Autowired
	DormServices dormServ;
	@Autowired
	StudentServices studentServ;
	
	@GetMapping("/new")
	public String index(Model model) {
		model.addAttribute("newDorm", new Dorm());
		return "dorms/new.jsp";
	}
	
	@PostMapping("/process")
	public String create(@Valid @ModelAttribute("newDorm") Dorm dorm, BindingResult result) {
		if (result.hasErrors()) {
			return "dorms/new.jsp";
		} else {
			dormServ.createContact(dorm);
			return "redirect:/students";
		}
	}
	
	@GetMapping("/{id}")
	public String addStudent(Model model, @PathVariable("id") Long dorm_id, @ModelAttribute("student") Student student) {
		
		List<Student> students = studentServ.findByDormIsNull();
		model.addAttribute("students", students);
		
		Dorm oneDorm = dormServ.findById(dorm_id);
		model.addAttribute("dorm", oneDorm);

		return "dorms/show.jsp";
	}
	
	@PostMapping("/{id}/process")
	public String addStudent(Model model, @RequestParam("students") Long student_id, @PathVariable("id") Long dorm_id, @ModelAttribute("newDorm") Dorm dorm) {
		Dorm oneDorm = dormServ.findById(dorm_id);
		Student student = studentServ.findById(student_id);
		
		student.setDorm(oneDorm);
		studentServ.createOrUpdateStudent(student);
		
		return "redirect:/dorms/" + dorm_id;
	}
}
