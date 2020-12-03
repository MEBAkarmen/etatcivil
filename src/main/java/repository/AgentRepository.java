package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Agent;
import entity.Naissance;

public interface AgentRepository extends JpaRepository <Agent,Long> {
	
	 List<Agent> findByNaissance(Naissance naissance);

}
