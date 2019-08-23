package com.springdata.studentroster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdata.studentroster.models.StudentCourse;
import com.springdata.studentroster.repository.StudentCourseRepository;
@Service

public class StudentCourseService {
	@Autowired
	StudentCourseRepository studentCourseRepo;
	
	public StudentCourse createRelationship(StudentCourse sc) {
		return studentCourseRepo.save(sc);
	}
	public void deleteRelationship(Long id) {
		studentCourseRepo.deleteById(id);
		return;
	}
}
