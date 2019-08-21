package com.springdata.studentroster.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springdata.studentroster.models.Dorm;

public interface DormRepository extends CrudRepository <Dorm, Long> {
	List<Dorm> findAll();

    void deleteById(Long id);
}
