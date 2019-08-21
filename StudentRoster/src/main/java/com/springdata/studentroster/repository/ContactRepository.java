package com.springdata.studentroster.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springdata.studentroster.models.Contact;

public interface ContactRepository extends CrudRepository <Contact, Long> {
	List<Contact> findAll();

    void deleteById(Long id);
}
