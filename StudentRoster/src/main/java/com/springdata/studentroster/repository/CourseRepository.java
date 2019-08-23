package com.springdata.studentroster.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springdata.studentroster.models.Course;

public interface CourseRepository extends CrudRepository <Course, Long>{
	
	List<Course> findAll();

	
}
