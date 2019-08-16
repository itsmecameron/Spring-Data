package com.springdata.languages.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.springdata.languages.models.Language;
import com.springdata.languages.services.LanguageService;


@Controller
public class LanguageController {
//    private final BookService bookService;
    @Autowired
    LanguageService languageServ;
    
    @GetMapping("/")
    public String home(Model model, @ModelAttribute("newLanguageObject") Language language) {
    	List<Language> allLanguage = languageServ.allLanguage();
    	model.addAttribute("languages", allLanguage);
    	return "language/index.jsp";
    }
    
//    @GetMapping("/createNewLanguage")
//    public String newLanguage(Model model) {
//    	model.addAttribute("newLanguageObject", new Language());
//    	return "language/new.jsp";
//    }
    
    @PostMapping("/language/process")
    public String createLanguage (@Valid @ModelAttribute("newLanguageObject") Language language, BindingResult results) {
		if(results.hasErrors()) {
			return "language/index.jsp";
		}
		languageServ.createOrUpdateLanguage(language);
		System.out.println(language.getVersion());
		return "redirect:/";
    }
   
    @GetMapping("/language/{language_id}/show")
    public String show(@PathVariable("language_id") Long id, Model model) {
    	Language language = languageServ.findLanguage(id);
    	model.addAttribute("Language", language);
    	return "language/show.jsp";
    }
    
    @GetMapping("/language/{language_id}/edit")
    public String editLanguage(Model model, @PathVariable("language_id") Long id) {
    	Language language = languageServ.findLanguage(id);
    	 model.addAttribute("language", language);
    	 return "language/edit.jsp";
    }
    
    @PutMapping("/language/{id}")
    public String updateBook(@Valid @ModelAttribute("language") Language language, BindingResult results) {
    	if(results.hasErrors()) {
			return "language/edit.jsp";
		}
		languageServ.createOrUpdateLanguage(language);
		return "redirect:/";
    }
    
    @DeleteMapping("/language/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        languageServ.deleteLanguage(id);
        return "redirect:/";
    }
}