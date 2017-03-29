package com.persistance; 
import java.sql.*;
import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Tarif;
import com.metier.TypeDechet;
import com.metier.Usager;
import com.metier.Utilisateur;

public class AccesData {
private static Session s = HibernateSession.getSession();

	public static ArrayList<Habitation> getHabitation(){
		Session s = HibernateSession.getSession();
		ArrayList<Habitation> hab = (ArrayList<Habitation>) s.createQuery("from Habitation h ").list();
		return hab;
	}
	public static ArrayList<Habitation> getLesHabitations(String idUsager){
		Session s = HibernateSession.getSession();
		ArrayList<Habitation> hab = (ArrayList<Habitation>) s.createQuery("from Habitation h where h.usager = '"+idUsager+"'").list();
		return hab;
	}
	public static Habitation getUneHabitation(String id){
		Habitation h = null;
		String hql = "from Habitation h where h.idHabitation= '"+id+"'";
		//System.out.println(hql);
		h = (Habitation) s.createQuery(hql).uniqueResult();
		return h;
	}	
		
	
	public static boolean ajoutLevee(Levee l){
		boolean retour =false;
		try {
			Transaction t = s.beginTransaction();
			s.save(l);
			t.commit();
			retour = true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			retour = false;
			e.printStackTrace();
		}
		return retour;
	}
	
	public static boolean ajoutFacture(Facture f){
		boolean retour =false;
		try {
			Transaction t = s.beginTransaction();
			s.save(f);
			t.commit();
			retour=true;
		} catch (HibernateException e) {
			retour=false;
			e.printStackTrace();
		}
		return retour;
	}
	
	public static boolean ajouterControleFacture(Facture f){
		boolean ok = false;
		String hql ="from Facture f where f.ans = " + f.getAns();
		hql = hql + "and f.mois = "+f.getMois();
		hql = hql +"and f.idHabitation = '"+f.getIdHabitation()+"'";
		
		Facture existF = (Facture) s.createQuery(hql).uniqueResult();
		if(existF == null){
			try {
				Transaction t = s.beginTransaction();
				s.save(f);
				t.commit();
				ok=true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ok;
		
	}
	public static Tarif getTarif(int id){
		Tarif t =(Tarif) s.get(Tarif.class, id);
		return t;
	}
	
	public static Utilisateur getUtilisateur(String login, String mdp){
		Utilisateur u = null;
		String hql = "from Utilisateur u where u.login = '"+login+"' and u.mdp = '"+mdp+"'";
		//System.out.println(hql);
		u = (Utilisateur) s.createQuery(hql).uniqueResult();
		return u;
		
		
	}
	
	public static ArrayList<Usager> getUsager(){
		ArrayList<Usager> u = null;
		String hql = "from Usager u";
		u = (ArrayList<Usager>) s.createQuery(hql).list();
		return u;
	}
	
	public static boolean ajoutTypeDechet(TypeDechet td){
		boolean retour =false;
		try {
			Transaction t = s.beginTransaction();
			s.save(td);
			t.commit();
			retour = true;
		} catch (HibernateException e) {
			retour = false;
			e.printStackTrace();
		}
		return retour;
	}
	
	public static ArrayList<Tarif> getTarif(){
		ArrayList<Tarif> u = null;
		String hql = "from Tarif t";
		u = (ArrayList<Tarif>) s.createQuery(hql).list();
		return u;
	}
	public static ArrayList<TypeDechet> getTypeDechet(){
		ArrayList<TypeDechet> u = null;
		String hql = "from TypeDechet t";
		u = (ArrayList<TypeDechet>) s.createQuery(hql).list();
		return u;
	}
	
	public static TypeDechet getTypeDechet(String id){
		TypeDechet u = null;
		String hql = "from TypeDechet t where idtypedechet = '"+id+"'";
		u = (TypeDechet) s.createQuery(hql).uniqueResult();
		return u;
	}
	
	public static Usager getUsager(String login ,String mdp){
		Usager u = null;
		String hql = "from Usager t where login = '"+login+"' and mdp = '"+mdp+"'";
		u = (Usager) s.createQuery(hql).uniqueResult();
		return u;
	}
}
