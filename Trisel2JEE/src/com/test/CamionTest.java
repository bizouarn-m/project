package com.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.Camion;

public class CamionTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    Camion camion;
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
   	 camion= new Camion("test",d);
    }

    @After
    public void tearDown() throws Exception {
   	 camion= null;
    }

    @Test
    public void testGetImmatriculation() {
   	 assertEquals("Est ce que l'immatriculation est correct", "test" , camion.getImmatriculation());
   	 //fail("Not yet implemented");
    }

    @Test
    public void testSetImmatriculation() {
   	 camion.setImmatriculation("truc");
   	 //fail("Not yet implemented");
    }

    @Test
    public void testGetDateDeMiseEnCirculation() {
    	assertEquals("Est ce que la date de mise en circulation est correct", "21/09/2016" ,sdf.format(camion.getDateDeMiseEnCirculation()));
   	 //fail("Not yet implemented");
    }

    @Test
    public void testSetDateDeMiseEnCirculation() {
    	try{
        	d = sdf.parse("21/09/2016");
        	} 
        	catch (ParseException e){
        	e.printStackTrace();
        	}
    	camion.setDateDeMiseEnCirculation(d);
   	 //fail("Not yet implemented");
    }
}