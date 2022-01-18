package com.austin.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.austin.languages.models.Language;
import com.austin.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository repo) {
		this.langRepo = repo;
	}
	
//	Find all
	public List<Language> allLanguages(){
		return this.langRepo.findAll();
	}
	
//	Find one
	public Language findLanguage(Long id) {
		return this.langRepo.findById(id).orElse(null);
	}
	
//	Create
	public Language createLanguage(Language newLang) {
		return this.langRepo.save(newLang);
	}
	
//	Update
	public Language updateLanguage(Language editLang) {
		return this.langRepo.save(editLang);
	}
	
//	Delete
	public void deleteLanguage(Long id) {
		 this.langRepo.deleteById(id);
	}
}