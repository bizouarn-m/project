package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Habitation;
import com.metier.Usager;

public class UsagerTest {
private Usager u;
private ArrayList<Habitation> lesHab;
private Habitation h;

	@Before
	public void setUp() throws Exception {
		u = new Usager("01", "nom", "prenom","rue", "ville","29600");
		h = new Habitation("idH1","rue","ville","29600",3, u);
		lesHab = new ArrayList<Habitation>();
		lesHab.add(h);
		u.setLesHabitations(lesHab);
	}

	@After
	public void tearDown() throws Exception {
		u = null;
		lesHab= null;
		h = null;
	}

	@Test
	public void testGetLesHabitations() {
		assertEquals("Est ce que leshabs est correct",lesHab,u.getLesHabitations());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetLesHabitations() 
	{
		h = new Habitation("idH2","rue","ville","29601",5, u);
		lesHab.add(h);
		assertEquals("Est ce que leshabs est correct",lesHab,u.getLesHabitations());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetIdUsager() {
		assertEquals("Est ce que l'id est correct","01",u.getIdUsager());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetIdUsager() {
		u.setIdUsager("02");
		assertEquals("Est ce que l'id est correct","02",u.getIdUsager());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetNom() {
		assertEquals("Est ce que le nom est correct","nom",u.getNom());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetNom() {
		u.setNom("nom2");
		assertEquals("Est ce que le nom est correct","nom2",u.getNom());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetPrenom() {
		assertEquals("Est ce que le nom est correct","prenom",u.getPrenom());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetPrenom() {
		u.setPrenom("prenom2");
		assertEquals("Est ce que le nom est correct","prenom2",u.getPrenom());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetAdresseRueUsager() {
		assertEquals("Est ce que le nom est correct","rue",u.getAdresseRueUsager());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetAdresseRueUsager() {
		u.setAdresseRueUsager("rue2");
		assertEquals("Est ce que le nom est correct","rue2",u.getAdresseRueUsager());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetAdresseVilleUsager() {
		assertEquals("Est ce que le nom est correct","ville",u.getAdresseVilleUsager());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetAdresseVilleUsager() {
		u.setAdresseVilleUsager("ville2");
		assertEquals("Est ce que le nom est correct","ville2",u.getAdresseVilleUsager());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCpUsager() {
		assertEquals("Est ce que le nom est correct","29600",u.getCpUsager());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetCpUsager() {
		u.setCpUsager("29601");
		assertEquals("Est ce que le nom est correct","29601",u.getCpUsager());
		//fail("Not yet implemented");
	}
	@Test
	public void testAddHabitation() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSupprHabitation() {
		//fail("Not yet implemented");
	}

}
