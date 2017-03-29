package com.util;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.metier.Levee;
import com.persistance.AccesData;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class InsertionLeves {

	
	/**
	 * Lire un fichier texte
	 * @param nomFichier
	 * nom du fichier à lire
	 */
	public static void traitementFichierTexte(String nomFichier) {
		FichierTexte fichier = new FichierTexte();
		boolean ouvrirFichier = fichier.openFileReader(nomFichier);
		String ligne;
		String[] data;
		String[] dataleve;
		if (ouvrirFichier == true) {
			ligne = fichier.readLigne();
			data = ligne.split(":");
			String immatriculation = data[0];
			System.out.println("Immatriculation : " + immatriculation);
			String idChauffeur = data[1];
			System.out.println("Code chauffeur : " + idChauffeur);
			System.out.println("date : " + data[2]);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				java.util.Date laDate = sdf.parse(data[2]);
				while ((ligne = fichier.readLigne()) != null) {
					dataleve = ligne.split(":");
					
					String codePoubelle = dataleve[0];
					System.out.println("Code poubelle : " + codePoubelle);
					Double poid =Double.parseDouble(dataleve[1]);// convertir double
					System.out.println("Poids : " + poid);
					
					Levee le1 = new Levee(laDate, poid , codePoubelle, immatriculation ,idChauffeur);
					if (AccesData.ajoutLevee(le1))
					{
						System.out.println("Creation ok");
					}
					else
					{
						System.out.println("Creation écheque");
					}
					
				}
				
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		} else {
			// Problème lors de la lecture
			System.out.println("fichier non trouvé");
		}
		fichier.closeFileReader();
	}

	/**
	 * Lire un fichier XML
	 * @param nomFichier
	 * nom du fichier à lire
	 */
	public static void traitementFichierXML(String nomFichier) {
		String poubelle;
		Double poids;
		// déclaration document xml
		Document document = null;
		// déclaration élément racine
		Element racine = null;
		// On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try {
			// On crée un nouveau document JDOM avec en argument le fichier XML
			document = sxb.build(new File(nomFichier));
			// On initialise un nouvel élément racine avec l'élément racine du
			// document.
			racine = document.getRootElement();
			// recuperation de l'entête
			String immatriculation = racine.getChild("immatriculation").getText();
			System.out.print("Immatriculation : " + immatriculation + "  ");
			String idChauffeur = racine.getChild("codechauffeur").getText() ;
			System.out.print("Code chauffeur : " + idChauffeur+ "  ");
			System.out.print("date : " + racine.getChild("date").getText());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				java.util.Date laDate = sdf.parse(racine.getChild("date").getText());

				// On crée une List contenant tous les noeuds "levee"
				List<Element> listLevee = racine.getChildren("levee");
				// parcours
				for (Element e : listLevee) {
					System.out.print("levee:  ");
					String codePoubelle = e.getChild("poubelle").getText() ;
					System.out.print(codePoubelle+ "  ");
					poubelle = e.getChild("poubelle").getText();
					System.out.println(e.getChild("poids").getText());
					poids = Double.parseDouble(e.getChild("poids").getText());
					
					Levee le1 = new Levee(laDate, poids , codePoubelle, immatriculation ,idChauffeur);
					if (AccesData.ajoutLevee(le1))
					{
						System.out.println("Creation ok");
					}
					else
					{
						System.out.println("Creation écheque");
					}
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}

		catch (JDOMException e2) {

			e2.printStackTrace();
		} catch (IOException e2) {

			e2.printStackTrace();
		}
	}
	/**
	 * Lire et deplacer un fichier
	 */
	public static void traitementLevee(){
		String cheminATraiter = Parametre.getCheminLeveeATraiter();
		String cheminTraites = Parametre.getCheminLeveeTraites();
		String cheminLog = Parametre.getCheminLeveeLog();
		File f = new File(cheminATraiter);
		if (f.list() == null)
		{
			System.out.println("aucun fichier à traiter");
		}
		else
		{
			File[] listeFichier = f.listFiles();
			for(File fichier : listeFichier)
			{
				if (fichier.isFile())
				{
					String extention = Parametre.getExtensionFichier(fichier.getName());
					switch (extention)
					{
					case "txt":
						traitementFichierTexte(fichier.getAbsolutePath());
						Parametre.transfertFichier(fichier,cheminTraites);
						break;
					case "xml":
						traitementFichierXML(fichier.getAbsolutePath());
						Parametre.transfertFichier(fichier,cheminTraites);
						break;
					default :
						System.out.println("Fichier incorect");
						Parametre.transfertFichier(fichier,cheminLog);
						break;
					}
				}
			}
		}
	}
}
