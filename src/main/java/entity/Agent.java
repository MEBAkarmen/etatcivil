package entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Agent {

	
	private long id;
	private String fonction;
	
	 
    @Column(length=30)
    private String nom ;

    @OneToOne
    private Type_agent type_agent ;
    
    
    @OneToMany
    private Collection<Agent> Agents ;
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	
}
