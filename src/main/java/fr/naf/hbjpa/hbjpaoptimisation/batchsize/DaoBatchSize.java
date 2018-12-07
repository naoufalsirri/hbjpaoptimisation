package fr.naf.hbjpa.hbjpaoptimisation.batchsize;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class DaoBatchSize {

	private static EntityManagerFactory emf;
	private static EntityManager em1;	
	private static EntityTransaction ts1;
	
	
	public DaoBatchSize() {
		 emf = Persistence.createEntityManagerFactory("persistence");    						         
		 em1 = emf.createEntityManager();
		 ts1= em1.getTransaction();
		 
		
	}
	
	public Guide ajouterGuide() {
		Guide guide =new Guide();
		guide.setNom("Farad");
		guide.setSalaire(3000);		
		ts1.begin();
        em1.persist(guide);                 
        ts1.commit(); 
		return guide;
	}
	
	public void ajouterEleve(Guide guide) {
		Eleve eleve =new Eleve();
		eleve.setNom("Tom");
		eleve.setGuide(guide);
		
		Eleve eleve1 =new Eleve();
		eleve1.setNom("Jery");
		eleve1.setGuide(guide);
		ts1.begin();
        em1.persist(eleve);
        em1.persist(eleve1);      
        ts1.commit();         
	}
	
	public List<Eleve> recupererLesTuplesAvecOptimisation() {
			
		//requete:
		//select eleve0_.id as id1_0_, eleve0_.guide_id as guide_id3_0_, eleve0_.nom as nom2_0_ from Eleve eleve0_
		
        Query queryJpqlJointure = em1.createQuery("select eleve from Eleve eleve");
		
        List<Eleve> resultList = queryJpqlJointure.getResultList();
        
        for(Eleve eleve:resultList) {
        	//requete charge pour 4 guides:
        	//select guide0_.id as id1_2_0_, guide0_.nom as nom2_2_0_, guide0_.salaire as 
        	//salaire3_2_0_ from Guide guide0_ where guide0_.id in (?, ?, ?, ?)
        	System.out.println("Eleve : "+eleve.getNom() +" ,son Guide: " +eleve.getGuide().getNom());
        }
		
		return resultList;
		
	}
	
	
}
