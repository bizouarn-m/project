package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.Facture;

public class FactureTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	Facture facture;
	@Before
	public void setUp() throws Exception {
		facture = new Facture(1,10,2017,"leveePoubelle1");
	}

	@After
	public void tearDown() throws Exception {
		facture = null;
	}

	@Test
	public void testFactureIntIntString() {
		facture = new Facture (11,2017,"leveePoubelle2");
		//fail("Not yet implemented");
	}

	@Test
	public void testFactureIntIntIntString() {
		facture = new Facture (2,12,2017,"leveePoubelle3");
		//fail("Not yet implemented");
	}

	@Test
	public void testGetIdFacture() {
		assertEquals("Est ce que l'id est correct", 1 , facture.getIdFacture());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetIdFacture() {
		facture.setIdFacture(2);
		assertEquals("Est ce que l'id est correct", 2 , facture.getIdFacture());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetMois() {
		assertEquals("Est ce que le mois est correct", 10 , facture.getMois());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetMois() {
		facture.setMois(9);
		assertEquals("Est ce que le mois est correct", 9 , facture.getMois());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetAns() {
		assertEquals("Est ce que l'année est correct", 2017, facture.getAns());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetAns() {
		facture.setAns(2015);
		assertEquals("Est ce que l'année est correct", 2015, facture.getAns());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetNomFacture() {
		assertEquals("Est ce que le nom de la facture est correct", "leveePoubelle1" , facture.getNomFacture());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetNomFacture() {
		facture.setNomFacture("test");
		assertEquals("Est ce que le nom de la facture est correct", "test" , facture.getNomFacture());
		//fail("Not yet implemented");
	}

}
