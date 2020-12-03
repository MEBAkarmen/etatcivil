package entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Clinique {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@OneToMany
	private List<AgentSante> agentSantes;
	
	
		
	public List<AgentSante> getAgentSante() {
		return agentSantes;
	}
	public void setAgentSante(List<AgentSante> agentSante) {
		this.agentSantes = agentSante;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
