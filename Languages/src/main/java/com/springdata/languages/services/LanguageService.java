package com.springdata.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springdata.languages.models.Language;
import com.springdata.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	// variable to call all methods in repository
	// adding the book repository as a dependency
	private LanguageRepository languageRepo;

	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}

	// returns all the books
	public List<Language> allLanguage() {
		return this.languageRepo.findAll();
	}
	
	// creates a book and is also a method to use to update a book
	public Language createOrUpdateLanguage(Language b) {
		System.out.println(b.getVersion());
		Language l = languageRepo.save(b);
		System.out.println(l.getVersion());
		return l;
//		return languageRepo.save(b);
		
	}

	// retrieves a book
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepo.findById(id); // Optional means that it could exist or not
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}

	public Language updateLanguage(Long id, String name, String creator, double version) {
		// TODO Auto-generated method stub
		Language updateLanguage = languageRepo.findById(id).get();
		updateLanguage.setName(name);
		updateLanguage.setCreator(creator);
		updateLanguage.setVersion(version);

		languageRepo.save(updateLanguage);
		return updateLanguage;
	}

	public void deleteLanguage(Long id) {
		languageRepo.deleteById(id);
	}	
}