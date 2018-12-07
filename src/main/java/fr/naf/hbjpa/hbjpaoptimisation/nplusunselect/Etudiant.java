package fr.naf.hbjpa.hbjpaoptimisation.nplusunselect;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Etudiant {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	
	private String classe;

	@ManyToOne(cascade= {CascadeType.PERSIST},fetch=FetchType.LAZY)
	@JoinColumn(name="prof_id")
	private Professeur professeur;
	
	public Etudiant() {
		super();
	}

	
	public Etudiant(String nom, String classe,Professeur professeur) {
		super();
		this.nom = nom;
		this.classe = classe;
		this.professeur =professeur;
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


	public String getClasse() {
		return classe;
	}


	public void setClasse(String classe) {
		this.classe = classe;
	}


	public Professeur getProfesseur() {
		return professeur;
	}


	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	
	
}
