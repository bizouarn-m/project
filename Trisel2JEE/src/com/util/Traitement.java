package com.util;

import java.util.List;
import java.util.Scanner;

import com.metier.Habitation;
import com.pdf.EditionFacture;
import com.persistance.AccesData;

public class Traitement {
	public static boolean insertion(){
		boolean ok = false;
		int nbFichiers = Parametre.nblevee();
		System.out.println("Nombre de fichiers : "+ nbFichiers);
		if(nbFichiers ==0){
			System.out.println("aucun fichier à traiter");
		}
		else{
			InsertionLeves.traitementLevee();
			System.out.println("Traitement terminer");
		}
		return ok;
	}
	public static boolean facturation(){
		boolean ok = false;
		Scanner in = new Scanner(System.in);
		List<Habitation> listeHab = AccesData.getLesHabitations();
		System.out.println("Donner le numéro du mois :");
		int mois = in.nextInt();
		System.out.println("Donner le numéro de l'année :");
		int an = in.nextInt();
		if(listeHab.size()!= 0){
			for(Habitation h : listeHab){
				EditionFacture.editionElementfacture(h, an, mois);
			}
			System.out.println("Traitement terminer");
			ok = true;
		}
		else{
			System.out.println("Aucun habitation à traiter");
		}
		return ok;
	}
}
