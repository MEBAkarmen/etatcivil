package entity;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class AgentSante extends Personne {

	private String fonction;
	@OneToOne(mappedBy="agentSante")
	private CompteUser compteUser;
	@ManyToOne
	private Clinique clinique;
	@OneToMany
	private List<Declaration> declarations;
	
	public CompteUser getCompteUtilisateur() {
		return compteUser;
	}
	public void setCompteUtilisateur(CompteUser compteUtilisateur) {
		this.compteUser = compteUtilisateur;
	}
	public Clinique getClinique() {
		return clinique;
	}
	public void setClinique(Clinique clinique) {
		this.clinique = clinique;
	}
	public List<Declaration> getDeclarations() {
		return declarations;
	}
	public void setDeclarations(List<Declaration> declarations) {
		this.declarations = declarations;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
	

}
