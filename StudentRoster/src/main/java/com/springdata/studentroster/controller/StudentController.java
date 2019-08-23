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

import com.springdata.studentroster.models.Course;
import com.springdata.studentroster.models.Student;
import com.springdata.studentroster.models.StudentCourse;
import com.springdata.studentroster.services.ContactServices;
import com.springdata.studentroster.services.CourseService;
import com.springdata.studentroster.services.DormServices;
import com.springdata.studentroster.services.StudentCourseService;
import com.springdata.studentroster.services.StudentServices;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	StudentServices studentServ;
	@Autowired 
	ContactServices contactServ;
	@Autowired
	CourseService courseServ;
	@Autowired
	DormServices dormServ;
	@Autowired
	StudentCourseService studentCourseServ;
	
	@GetMapping("")
	public String home(Model model, @ModelAttribute("newStudent") Student student) {
		List<Student> allStudents = studentServ.allStudents();
		model.addAttribute("students", allStudents);
		return "student/index.jsp";
	}
	
	@GetMapping("/new")
	public String newStudent(Model model) {
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
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Long student_id) {

		model.addAttribute("middleTable", new StudentCourse());
		
		List<Course> courses = courseServ.findAll();
		model.addAttribute("courses", courses);

		Student student = studentServ.findById(student_id);
		model.addAttribute("student", student);

		return "student/show.jsp";
	}
	
	@PostMapping("/{id}/process")
	public String addClass(Model model, @PathVariable("id") Long student_id, @RequestParam("course_id") Long course_id) {
		Course course = courseServ.findById(course_id);
		Student student = studentServ.findById(student_id);
		StudentCourse sc = new StudentCourse (student, course);
		
		studentCourseServ.createRelationship(sc);
		
		return "redirect:/students/" + student_id;
	}
	@GetMapping("/{id}/delete")
	public String removeStudent(@PathVariable("id") Long course_id, @RequestParam("student_id")Long student_id) {
		studentServ.removeCourse(student_id, course_id);
		return "redirect:/students/" + student_id; 
	}
}
