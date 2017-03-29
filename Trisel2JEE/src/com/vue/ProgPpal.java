package com.vue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metier.Facture;
import com.metier.Levee;
import com.metier.TypeDechet;
import com.pdf.EditionFacture;
import com.persistance.AccesData;
import com.persistance.HibernateSession;
import com.util.Traitement;


public class ProgPpal {

	private static SimpleDateFormat dateFormat;

	public static void main(String[] args){
		//EditionFacture.testFacture();
		//Session s = HibernateSession.getSession();	
		
		//--FIND--
		/*TypeDechet td =(TypeDechet) s.get(TypeDechet.class, "ver");
		System.out.println(td.toString());*/
		//--RETRIVE--
		//ArrayList<TypeDechet> listeDechet = (ArrayList<TypeDechet>) s.createQuery("from TypeDechet").list();
		//--CREATE
		/*TypeDechet td1 = new TypeDechet("pap","papier",0.12);
		Transaction t = s.beginTransaction();
		s.save(td1);
		t.commit();*/
		
		//Facture f = new Facture(11,2016,"test","hab1");
		//AccesData.ajoutFacture(f);
		
		/*Date laDate =null;
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			
			laDate = dateFormat.parse("15/05/2015");
			Levee l = new Levee(laDate,5.5,"pb1","BM-330-EF","C100");
			AccesData.ajoutLevee(l);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		
		//System.out.println(AccesData.getTarif(1).toString());
		
		//System.out.println(AccesData.getLesHabitations());
		
		//EditionFacture.testFacture();
		//Traitement.insertion();
		//Traitement.facturation();

		Session s = HibernateSession.getSession();		
		//System.out.println(AccesData.getUtilisateur("lequay","tyty"));
		//System.out.println(AccesData.getTarif());
		//TypeDechet type = new TypeDechet("05","plastique",30.2);
		System.out.println(AccesData.getTypeDechet("pla"));
		
	}
}
