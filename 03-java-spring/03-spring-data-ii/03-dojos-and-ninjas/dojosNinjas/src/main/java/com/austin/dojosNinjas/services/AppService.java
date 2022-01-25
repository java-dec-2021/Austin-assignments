package com.austin.dojosNinjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.austin.dojosNinjas.models.Dojo;
import com.austin.dojosNinjas.models.Ninja;
import com.austin.dojosNinjas.repositories.DojoRepository;
import com.austin.dojosNinjas.repositories.NinjaRepository;

@Service
public class AppService {
	@Autowired
	private NinjaRepository nRepo;
	@Autowired
	private DojoRepository dRepo;
	
//	DOJO SERVICE:
	
//	find all dojos
	public List<Dojo> allDojos() {
		return this.dRepo.findAll();
	}
	
//	create dojo
	public Dojo createDojo(Dojo dojo) {
		return this.dRepo.save(dojo);
	}
	
//	find one dojo - to find all ninjas at one dojo - 
	public Dojo findOneDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
// NINJA SERVICE:	
	
//	find all ninjas
	public List<Ninja> allNinjas() {
		return this.nRepo.findAll();
	}
	
//	create ninja
	public Ninja createNinja(Ninja ninja) {
		return this.nRepo.save(ninja);
	}
	
	
}
