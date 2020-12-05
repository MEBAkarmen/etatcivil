package com.project.etatcivil.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.etatcivil.entity.Clinique;
import com.project.etatcivil.repository.CliniqueRepository;

@Service
public class CliniqueService {

	  private CliniqueRepository cliniqueRepository;
	  
	  public Clinique create(Clinique clinique) {
		 return cliniqueRepository.save(clinique)  ;
	  }

	  public Page<Clinique> getAll (Pageable pageable) {
			 return cliniqueRepository.findAll(pageable) ;
		  }

	  public Clinique getOne( Long id) {
			 return cliniqueRepository.getOne(id) ;
		  }
	  public void deleteById( Long id) {
			cliniqueRepository.deleteById(id);
		  }

	@Autowired
	public void setcliniqueRepository(CliniqueRepository cliniqueRepository) {
		this.cliniqueRepository = cliniqueRepository;
	}

}
