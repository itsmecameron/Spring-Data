package com.springdata.studentroster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springdata.studentroster.models.Contact;
import com.springdata.studentroster.repository.ContactRepository;

@Service
public class ContactServices {
	private ContactRepository contactRepo;
	
	public ContactServices(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}
	
	public List<Contact> allStudents(){
		return this.contactRepo.findAll();
	}
	
	public Contact createContact(Contact contact) {
		return contactRepo.save(contact);
	}
}
