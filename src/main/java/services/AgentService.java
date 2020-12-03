package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Agent;
import repository.AgentRepository;

@Service
public class AgentService {
	
	@Autowired
    private AgentRepository repository;
	
	 public List<Agent> listAll(){
	        return repository.findAll();
	    }
	    
	    public void save(Agent agent){
	        repository.save(agent);
	    }
	    
	    public Agent get(Long id){
	        return repository.findById(id).get();
	    }
	    
	    public void delete(Long id){
	        repository.deleteById(id);
	    }
	    

}
