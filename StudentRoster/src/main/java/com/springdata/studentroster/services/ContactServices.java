package com.springdata.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdata.studentroster.models.Contact;
import com.springdata.studentroster.repository.ContactRepository;

@Service
public class ContactServices {
	@Autowired
	ContactRepository contactRepo;
	
	public List<Contact> allContacts(){
		return contactRepo.findAll();
	}
	
	public Contact createContact(Contact contact) {
		return contactRepo.save(contact);
	}
}
