package com.springdata.studentroster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springdata.studentroster.models.Student;
import com.springdata.studentroster.repository.StudentRepository;

@Service
public class StudentServices {
	private StudentRepository studentRepo;
	
	public StudentServices(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}
	public List<Student>allStudents(){
		return this.studentRepo.findAll();
	}
	public Student createOrUpdateStudent(Student s) {
		return studentRepo.save(s);
	}
}
