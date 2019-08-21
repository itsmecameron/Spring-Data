package com.springdata.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdata.studentroster.models.Student;
import com.springdata.studentroster.repository.StudentRepository;

@Service
public class StudentServices {
	@Autowired
	StudentRepository studentRepo;
	
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
}
