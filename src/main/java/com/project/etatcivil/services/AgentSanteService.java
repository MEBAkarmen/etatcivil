package com.project.etatcivil.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.etatcivil.entity.AgentSante;
import com.project.etatcivil.repository.AgentSanteRepository;



@Service
public class AgentSanteService {
	
	private AgentSanteRepository agentSanteRepository;
	 
	  public AgentSante create(AgentSante agentSante) {
		 return agentSanteRepository.save(agentSante)  ;
	  }

	  public Page<AgentSante> getAll (Pageable pageable) {
			 return agentSanteRepository.findAll(pageable) ;
		  }

	  public AgentSante getOne( Long id) {
			 return agentSanteRepository.getOne(id) ;
		  }
	  public void deleteById( Long id) {
			agentSanteRepository.deleteById(id);
		  }

	@Autowired
	public void setAgentSanteRepository(AgentSanteRepository agentSanteRepository) {
		this.agentSanteRepository = agentSanteRepository;
	}

}
