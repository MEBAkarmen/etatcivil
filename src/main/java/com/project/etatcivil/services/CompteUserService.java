package com.project.etatcivil.services;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.etatcivil.entity.CompteUser;
import com.project.etatcivil.repository.CompteUserRepository;

@Service
public class CompteUserService {
     
	 
	  private CompteUserRepository compteUserRepository;
	  
	  public CompteUser create(CompteUser compteUser) {
		 return compteUserRepository.save(compteUser)  ;
	  }

	  public Page<CompteUser> getAll (Pageable pageable) {
			 return compteUserRepository.findAll(pageable) ;
		  }

	  public CompteUser getOne( Long id) {
			 return compteUserRepository.getOne(id) ;
		  }
	  public void deleteById( Long id) {
			compteUserRepository.deleteById(id);
		  }

	@Autowired
	public void setCompteUserRepository(CompteUserRepository compteUserRepository) {
		this.compteUserRepository = compteUserRepository;
	}
	  
}
