package fr.naf.hbjpa.hbjpaoptimisation.nplusunselect;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class DaoSelect {

	private static EntityManagerFactory emf;
	private static EntityManager em1;	
	private static EntityTransaction ts1;
	
	
	public DaoSelect() {
		 emf = Persistence.createEntityManagerFactory("persistence");    						         
		 em1 = emf.createEntityManager();
		 ts1= em1.getTransaction();
		 
		
	}
	
	public Professeur ajouterProfesseur() {
		Professeur professeur =new Professeur();
		professeur.setNom("Jad");
		professeur.setSalaire(4000);		
		ts1.begin();
        em1.persist(professeur);                 
        ts1.commit(); 
		return professeur;
	}
	
	public void ajouterEtudiant(Professeur professeur) {
		Etudiant etudiant =new Etudiant();
		etudiant.setNom("Tom");
		etudiant.setClasse("classe1");
		etudiant.setProfesseur(professeur);
		Etudiant etudiant1 =new Etudiant();
		etudiant1.setNom("Com");
		etudiant1.setClasse("classe1");
		etudiant1.setProfesseur(professeur);
		ts1.begin();
        em1.persist(etudiant);
        em1.persist(etudiant1);      
        ts1.commit();         
	}
	
	public List<Etudiant> recupererTousLesTuplesEnUneSelect() {
				
		//requete:
		//select etudiant0_.id as id1_0_0_, professeur1_.id as id1_1_1_, etudiant0_.classe as classe2_0_0_, etudiant0_.nom as 
		//nom3_0_0_, etudiant0_.prof_id as prof_id4_0_0_, professeur1_.nom as nom2_1_1_, professeur1_.salaire as salaire3_1_1_ from 
		//Etudiant etudiant0_ inner join Professeur professeur1_ on etudiant0_.prof_id=professeur1_.id
		
        Query queryJpqlJointure = em1.createQuery("select etudiant from Etudiant etudiant join fetch etudiant.professeur");
		
        List<Etudiant> resultList = queryJpqlJointure.getResultList();
		
		return resultList;
		
	}
	
	
}
