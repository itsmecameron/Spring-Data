package com.springdata.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdata.studentroster.models.Course;
import com.springdata.studentroster.models.Student;
import com.springdata.studentroster.repository.CourseRepository;
import com.springdata.studentroster.repository.StudentCourseRepository;
import com.springdata.studentroster.repository.StudentRepository;

@Service
public class StudentServices {
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	StudentCourseRepository courseStudentRepo;
	
	@Autowired
	CourseService courseServ;
	
	public List<Student> allStudents() {
		return this.studentRepo.findAll();
	}

	public Student createOrUpdateStudent(Student s) {
		return studentRepo.save(s);
	}

	public List<Student> findByDormIsNull() {
		return studentRepo.findByDormIsNull();
	}
	
	public List<Student> findByContactIsNull() {
		return studentRepo.findByContactIsNull();
	}

	public Student findById(Long id) {
		Optional<Student> optionalStudent = studentRepo.findById(id);
		if (optionalStudent.isPresent()) {
			return optionalStudent.get();
		} else {
			return null;
		}
	}

	public Object removeCourse(Long student_id, Long course_id) {
		Student oneStudent = findById(student_id);
		Course oneCourse = courseServ.findById(course_id);
		
		List <Course> studentClasses = oneStudent.getCourses();
		System.out.println(oneStudent.getCourses()); // gets dictionary of objects
		
		studentClasses.remove(oneCourse); //remove the one course
		
		createOrUpdateStudent(oneStudent);
		return null;
	}

}
