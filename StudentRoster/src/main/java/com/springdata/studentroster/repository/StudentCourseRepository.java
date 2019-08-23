package com.springdata.studentroster.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springdata.studentroster.models.StudentCourse;

@Repository

public interface StudentCourseRepository extends CrudRepository <StudentCourse, Long> {
	
	void deleteById(Long id);
	
}
