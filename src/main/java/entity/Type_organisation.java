package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Type_organisation {

	private long id;
	private String libelle;
	
	 @Column(length=30)
     private String nom ;

     @OneToOne(mappedBy="type_organisation") 
     private Organisation organisation ;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
		
		
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
}
