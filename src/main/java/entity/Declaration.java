package entity;

import java.util.Collection;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Declaration {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public AgentSante getAgentSante() {
		return agentSante;
	}
	public void setAgentSante(AgentSante agentSante) {
		this.agentSante = agentSante;
	}
	private String nom_declarant;
	private String contact;
	@OneToOne
	private Personne personne;
	@ManyToOne
	private AgentSante agentSante;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom_declarant() {
		return nom_declarant;
	}
	public void setNom_declarant(String nom_declarant) {
		this.nom_declarant = nom_declarant;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	

}
