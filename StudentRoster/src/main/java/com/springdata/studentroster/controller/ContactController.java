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

import com.springdata.studentroster.models.Contact;
import com.springdata.studentroster.models.Student;
import com.springdata.studentroster.services.ContactServices;
import com.springdata.studentroster.services.StudentServices;

@Controller
public class ContactController {
	@Autowired
	ContactServices contactServ;
	@Autowired
	StudentServices studentServ;
	
	@GetMapping("/contact/new")
	public String index(Model model, @ModelAttribute("newContact") Contact contact) {
		List<Student> students = studentServ.allStudents();
		model.addAttribute("students", students);
		return "/contacts/new.jsp";
	}
	@PostMapping("/contact/process")
	public String create(@Valid @ModelAttribute("newContact") Contact contact, BindingResult result) {
		if (result.hasErrors()) {
			return "contacts/new";
		} else {
			contactServ.createContact(contact);
			return "redirect:/students";
		}
	}
}