package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.metier.TypeDechet;

public class TypeDechetTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    TypeDechet type;
    @Before
    public void setUp() throws Exception {
   	 type = new TypeDechet("05","plastique",30.2);
    }

    @After
    public void tearDown() throws Exception {
   	 type = null;
    }

    @Test
    public void testGetTypeDechet() {
   	 assertEquals("Est ce que le tarif est correct", "05" ,type.getTypeDechet());
   	 //fail("Not yet implemented");
    }

    @Test
    public void testSetTypeDechet() {
   	 type.setTypeDechet("03");
   	 //fail("Not yet implemented");
    }

    @Test
    public void testGetLibelle() {
   	 assertEquals("Est ce que le libelle est correct", "plastique" ,type.getLibelle());
   	 //fail("Not yet implemented");
    }

    @Test
    public void testSetLibelle() {
   	 type.setLibelle("papier");
   	assertEquals("Est ce que le libelle est correct", "papier" ,type.getLibelle());
   	 //fail("Not yet implemented");
    }

    @Test
    public void testGetTarif() {
   	 assertEquals("Est ce que le tarif est correct", "30.2" ,type.getTarif().toString());
   	 //fail("Not yet implemented");
    }

    @Test
    public void testSetTarif() {
   	 type.setTarif(15.3);
   	 assertEquals("Est ce que le tarif est correct", "15.3" ,type.getTarif().toString());
   	 //fail("Not yet implemented");
    }

}
