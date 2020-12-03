package entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Personne {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personneSequenceGenerator")
	@SequenceGenerator(name="personneSequenceGenerator")
	private Long id;
	private String nom;
	private String prenom;
	private String  adresse;
	private String sexe;
	private Date dateNaissance;
	@OneToOne(mappedBy="personne")
	private Declaration declaration;
	
		
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public Date getDate_naissance() {
		return dateNaissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.dateNaissance = date_naissance;
	}
	
	
	

}
