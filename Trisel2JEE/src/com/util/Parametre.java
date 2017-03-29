package com.util;
import java.io.File;

import com.metier.Habitation;

public class Parametre {
	private static String nomFichier = "paramAppli.ini";

	/**
	 * Ramène le chemin de "la BD" contenu dans paramAppli.ini
	 * @return
	 * chemin vers la BD
	 */
	public static String getCheminBd(){
		//2emme ligne du fichier "paramAppli.ini"
		return lire(2);
	}

	/**
	 * amène le chemin de "atraiter" contenu dans paramAppli.ini
	 * @return
	 * chemin vers "atraiter"
	 */
	public static String getCheminLeveeATraiter() {
		//4emme ligne du fichier "paramAppli.ini"
		return lire(4);
	}

	/**
	 * amène le chemin de "log" contenu dans paramAppli.ini
	 * @return
	 * chemin vers "log"
	 */
	public static String getCheminLeveeLog() {
		//10emme ligne du fichier "paramAppli.ini"
		return lire(10);
	}

	/**
	 * amène le chemin de "traites" contenu dans paramAppli.ini
	 * @return
	 * chemin vers "traites"
	 */
	public static String getCheminLeveeTraites() {
		//6emme ligne du fichier "paramAppli.ini"
		return lire(6);
	}

	/**
	 * amène le chemin des facturesPDF contenu dans "paramAppli.ini"
	 * @return
	 * chemin vers "facturePDF"
	 */
	public static String getCheminFacturePdf() {
		//8emme ligne du fichier "paramAppli.ini"
		return lire(8);
	}
	/**
	 * Lire et ramener une ligne contenue dans "paramAppli.ini"
	 * @param n
	 * ligne que l'on souhaite recupéré
	 * @return
	 * ligne n
	 */
	private static String lire(int n)
	{
		FichierTexte fichier = new FichierTexte();
		boolean ouvrirFichier = fichier.openFileReader(nomFichier);
		String ligne = null;
		for(int i =0; i <n; i++)
		{
			ligne = fichier.readLigne();
		}
		fichier.closeFileReader();
		return ligne;
	}
	
	/**
	 * Ramener l'extention d'un fichier
	 * @param nomFichier
	 * nom du fichier
	 * @return
	 * extention du fichier
	 */
	public static String getExtensionFichier(String nomFichier) {
		String[] fichier;
		fichier = nomFichier.split("\\.");
		return fichier[1];
	}
	
	/**
	 * Deplacer un fichier
	 * @param fichierSource
	 * fichier à deplacer
	 * @param cheminDestination
	 * Dossier destination
	 */
	public static void transfertFichier(File fichierSource, String cheminDestination)
	{
		cheminDestination = cheminDestination+"\\"+fichierSource.getName();
		File destination = new File(cheminDestination);
		try{
			fichierSource.renameTo(destination);
		}
		catch(Exception e)
		{
			System.out.println("Echec du déplacement");
		}
	}
	
	private static final String tabMois[]={"","janvier","fevrier","mars","avril","mai","juin","juillet","aout","septembre","octobre","novembre","decembre"};
	
	public static String getNomFichier(Habitation h , int mois , int ans)
	{ 
		String nomFichier = h.getIdHabitation()+"-"+h.getUsager().getIdUsager()+"-Facture-"+tabMois[mois]+"-"+ans+".pdf";
		return nomFichier;
		}
	
	public static String getCheminFichier(Habitation h , int mois , int an)
	{
		String nomDossier = Parametre.getCheminFacturePdf()+"\\"+tabMois[mois];
		String nomFichier = getNomFichier( h , mois , an);
		String cheminComplet = nomDossier +"\\"+nomFichier;
		return cheminComplet;
	}
	public static int nblevee(){
	String cheminsLevee = getCheminLeveeATraiter() ;
	File f = new File(cheminsLevee);
	return f.list().length;
	}
}



