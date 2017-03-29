package com.test;
import com.metier.Chauffeur;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChauffeurTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    Chauffeur c;
    Date d = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
    @Before
    public void setUp() throws Exception {	
    	try{
    	d = sdf.parse("21/09/2016");
    	} 
    	catch (ParseException e){
    	e.printStackTrace();
    	}
    	c = new Chauffeur("id5","Paul","test",d);
    }
    
    @After
    public void tearDown() throws Exception {
   	 c = null;
    }

    @Test
    public void testGetDateEmbauche() {
    	assertEquals("Est ce que la date d'embauche chauffeur est correct", "21/09/2016" ,sdf.format(c.getDateEmbauche()));
   	 //fail("Not yet implemented");
    }

    @Test
    public void testSetDateEmbauche() {
    	try{
        	d = sdf.parse("21/09/2016");
        	} 
        	catch (ParseException e){
        	e.printStackTrace();
        	}
    	c.setDateEmbauche(d);
   	 //fail("Not yet implemented");
    }

    @Test
    public void testGetIdChauffeur() {
   	 assertEquals("Est ce que L'id chauffeur est correct", "id5" ,c.getIdChauffeur());
   	 //fail("Not yet implemented");
    }

    @Test
    public void testSetIdChauffeur() {
   	 c.setIdChauffeur("id2");
   	 //fail("Not yet implemented");
    }

    @Test
    public void testGetNomChauffeur() {
   	 assertEquals("Est ce que Le nom chauffeur est correct", "Paul" ,c.getNomChauffeur());
   	 //fail("Not yet implemented");
    }

    @Test
    public void testSetNomChauffeur() {
   	 c.setNomChauffeur("test");
   	 //fail("Not yet implemented");
    }

    @Test
    public void testGetPrenomChauffeur() {
   	 assertEquals("Est ce que Le prenom chauffeur est correct", "test" ,c.getPrenomChauffeur());
   	 //fail("Not yet implemented");
    }

    @Test
    public void testSetPrenomChauffeur() {
   	 c.setPrenomChauffeur("truc");
   	 //fail("Not yet implemented");
    }

}