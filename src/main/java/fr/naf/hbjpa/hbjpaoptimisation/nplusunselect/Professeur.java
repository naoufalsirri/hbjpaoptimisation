package fr.naf.hbjpa.hbjpaoptimisation.nplusunselect;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professeur {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	private String nom;
	
	private long salaire;

	@OneToMany(mappedBy="professeur",cascade = {CascadeType.PERSIST})
	private Set<Etudiant> etudiants=new HashSet<Etudiant>();
	
	public Professeur() {
		super();
	}

	public Professeur(String nom, long salaire) {
		super();		
		this.nom = nom;
		this.salaire = salaire;
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

	public long getSalaire() {
		return salaire;
	}

	public void setSalaire(long salaire) {
		this.salaire = salaire;
	}

	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	public void ajouterEtudiant(Etudiant etudiant) {
		etudiants.add(etudiant);
		etudiant.setProfesseur(this);
	}
	
}
