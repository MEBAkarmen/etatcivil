package com.project.etatcivil.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.etatcivil.entity.Naissance;
import com.project.etatcivil.repository.NaissanceRepository;

@Service
public class NaissanceService {
	
	@Autowired
	 private NaissanceRepository repository;
	 public List<Naissance> listAll(){
	        return repository.findAll();
	    }
	    
	    public void save(Naissance naissance){
	        repository.save(naissance);
	    }
	    
	    public Naissance get(Long id){
	        return repository.findById(id).get();
	    }
	    
	    public void delete(Long id){
	        repository.deleteById(id);
	    }

}
