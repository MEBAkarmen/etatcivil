package com.project.etatcivil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.etatcivil.entity.Organisation;
import com.project.etatcivil.repository.OrganisationRepository;



@Service
public class OrganisationService {
	@Autowired
	 private OrganisationRepository repository;
	 public List<Organisation> listAll(){
	        return repository.findAll();
	    }
	    
	    public void save(Organisation organisation){
	        repository.save(organisation);
	    }
	    
	    public Organisation get(Long id){
	        return repository.findById(id).get();
	    }
	    
	    public void delete(Long id){
	        repository.deleteById(id);
	    }

}
