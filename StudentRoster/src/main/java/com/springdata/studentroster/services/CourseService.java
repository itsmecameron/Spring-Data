package com.springdata.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdata.studentroster.models.Course;
import com.springdata.studentroster.repository.CourseRepository;

@Service

public class CourseService {
	@Autowired
	private CourseRepository courseRepo;
	
	public List<Course> findAll() {
		return courseRepo.findAll();
	}
	
	public Course createCourse(Course course) {
		return courseRepo.save(course);
	}

	public Course findById(Long id) {
		Optional<Course> optionalCourse = courseRepo.findById(id);
		if (optionalCourse.isPresent()) {
			return optionalCourse.get();
		} else {
			return null;
		}
	}
}
