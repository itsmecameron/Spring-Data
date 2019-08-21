package com.springdata.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdata.studentroster.models.Dorm;
import com.springdata.studentroster.repository.DormRepository;

@Service
public class DormServices {
	@Autowired
	DormRepository dormRepo;

	public List<Dorm> allStudents() {
		return this.dormRepo.findAll();
	}

	public Dorm createContact(Dorm dorm) {
		return dormRepo.save(dorm);
	}

	public Dorm findById(Long id) {
		Optional<Dorm> optionalDorm = dormRepo.findById(id);
		if (optionalDorm.isPresent()) {
			return optionalDorm.get();
		} else {
			return null;
		}
	}
}
