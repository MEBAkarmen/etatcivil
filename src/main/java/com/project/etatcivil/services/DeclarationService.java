package com.project.etatcivil.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.etatcivil.entity.Declaration;
import com.project.etatcivil.repository.DeclarationRepository;

@Service
public class DeclarationService {

	  private DeclarationRepository declarationRepository;
	  
	  public Declaration create(Declaration declaration) {
		 return declarationRepository.save(declaration)  ;
	  }

	  public Page<Declaration> getAll (Pageable pageable) {
			 return declarationRepository.findAll(pageable) ;
		  }

	  public Declaration getOne( Long id) {
			 return declarationRepository.getOne(id) ;
		  }
	  public void deleteById( Long id) {
			declarationRepository.deleteById(id);
		  }

	@Autowired
	public void setCompteUserRepository(DeclarationRepository declarationRepository) {
		this.declarationRepository = declarationRepository;
	}

}
