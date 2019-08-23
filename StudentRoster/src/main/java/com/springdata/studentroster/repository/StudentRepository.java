package com.springdata.studentroster.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springdata.studentroster.models.Student;

@Repository
public interface StudentRepository extends CrudRepository <Student, Long>{
	List<Student> findAll();

	List<Student> findByDormIsNull();
	
	List<Student> findByContactIsNull();
	
	
	void deleteById(Long id);
}
