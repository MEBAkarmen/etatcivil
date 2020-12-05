package com.project.etatcivil.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.etatcivil.entity.Personne;
import com.project.etatcivil.repository.PersonneRepository;

@Service
public class PersonneService {

	 private PersonneRepository personneRepository;
	  
	  public Personne create(Personne personne) {
		 return personneRepository.save(personne) ;
	  }

	  public Page<Personne> getAll (Pageable pageable) {
			 return personneRepository.findAll(pageable) ;
		  }

	  public Personne getOne( Long id) {
			 return personneRepository.getOne(id) ;
		  }
	  public void deleteById( Long id) {
		  personneRepository.deleteById(id);
		  }

	@Autowired
	public void setCompteUserRepository(PersonneRepository personneRepository) {
		this.personneRepository = personneRepository;
	}
	  
}
