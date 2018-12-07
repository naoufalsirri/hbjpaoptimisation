package fr.naf.hbjpa.hbjpaoptimisation.batchsize;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;


public class Testhbjpaoptimisationbatchsize {

	@Test
	public void testDaoBatchSize() {
		DaoBatchSize dao= new DaoBatchSize();
		Guide guide = dao.ajouterGuide();
		dao.ajouterEleve(guide);
		List<Eleve> select = dao.recupererLesTuplesAvecOptimisation();
		assertNotNull(select);
		System.out.println(select.size());
		assertTrue(select.size()>0);	
	}
}
