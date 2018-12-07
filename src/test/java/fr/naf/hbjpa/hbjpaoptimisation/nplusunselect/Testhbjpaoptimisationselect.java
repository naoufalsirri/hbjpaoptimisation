package fr.naf.hbjpa.hbjpaoptimisation.nplusunselect;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;


public class Testhbjpaoptimisationselect {

	@Test
	public void testDaoSelect() {
		DaoSelect dao= new DaoSelect();
		Professeur professeur = dao.ajouterProfesseur();
		dao.ajouterEtudiant(professeur);
		List<Etudiant> select = dao.recupererTousLesTuplesEnUneSelect();
		assertNotNull(select);
		System.out.println(select.size());
		assertTrue(select.size()>0);	
	}
}
