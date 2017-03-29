package com.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;
import com.persistance.AccesData;
import com.util.Parametre;

public class EditionFacture {
	public static void testFacture() {
		int an = 2015;
		int mois = 7;
		
		ArrayList<Habitation> lesHabitations = AccesData.getLesHabitations();
		if (lesHabitations.size() != 0) {
			for (Habitation h : lesHabitations) {
				//System.out.println(h.getLesFactures());
				editionElementfacture(h, an, mois);
			}
		}
	}

	public static void editionElementfacture(Habitation h, int an, int mois) {
		
		DecimalFormat df2 = new DecimalFormat("#.##");
		// Habitation
		
		String adresseRueHab = h.getAdrRueHab();
		String adresseVilleHab = h.getAdrVilleHab();
		String cpHab = h.getCpHab();
		int nombreUsager = h.getNbPersonne();

		// Usager
		Usager u = h.getUsager();
		String codeUsager = u.getIdUsager();
		String nom = u.getNom();
		String prenom = u.getPrenom();
		String adresseRueUsager = u.getAdresseRueUsager();
		String adresseVilleUsager = u.getAdresseVilleUsager();
		String cpUsager = u.getCpUsager();

		// Poubelle
		List<Poubelle> lesPoubelles = h.getLesPoubelles();

		// Tarif
		double tarif = AccesData.getTarif(1).getValeur();
		double totalPart = tarif * nombreUsager;
		double totalHT = 0;
		double TVA = 20;
		double montantTotal;

		// date systeme
		SimpleDateFormat dateFormat = null;
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		String date = dateFormat.format(c.getTime());
		//System.out.println(date);
		
		// instanciation/création d'un nouveau document
				Document document = new Document ();	
				try {
					// création d'une instance pour associer le document avec le
					// fichier sur disque à créer
					String nomPdf = Parametre.getCheminFichier(h, mois, an);
					PdfWriter.getInstance(document, new FileOutputStream(nomPdf));
					// ouverture du document
					document.open ();
					
					// ajout des info au document 
						// date du systeme
					Paragraph dateSystem = new Paragraph(date);
					dateSystem.setAlignment(Element.ALIGN_RIGHT);
					document.add(dateSystem);
					
					//ajout image
					Image image1;
					try {
						image1 = Image.getInstance ("Trisel.jpg");						
						document.add (image1);
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
						//info Usager
					Paragraph infoUsager= new Paragraph(nom + " " + prenom);
					infoUsager.setAlignment(Element.ALIGN_RIGHT);
					document.add(infoUsager);
					Paragraph rueUsager  = new Paragraph(adresseRueUsager);
					rueUsager.setAlignment(Element.ALIGN_RIGHT);
					document.add(rueUsager);
					Paragraph villeUsager = new Paragraph(cpUsager + " " + adresseVilleUsager);
					villeUsager.setAlignment(Element.ALIGN_RIGHT);
					document.add(villeUsager);
					
						//info Habitation
					Paragraph phrase = new Paragraph("Adresse du logement concerné : ");
					phrase.setAlignment(Element.ALIGN_LEFT);
					document.add(phrase);
					Paragraph rueHab  = new Paragraph(adresseRueHab);
					rueHab.setAlignment(Element.ALIGN_LEFT);
					document.add(rueHab);
					Paragraph villeHab = new Paragraph(cpHab + " " + adresseVilleHab);
					villeHab.setAlignment(Element.ALIGN_LEFT);
					villeHab.setSpacingAfter(10);
					document.add(villeHab);
					Paragraph idUsager = new Paragraph("Code usager : " + codeUsager);
					idUsager.setAlignment(Element.ALIGN_LEFT);
					document.add(idUsager);
					Paragraph nbUsager = new Paragraph("Nombre de personnes déclarées : " + nombreUsager);
					nbUsager.setAlignment(Element.ALIGN_LEFT);
					nbUsager.setSpacingAfter(20);
					document.add(nbUsager);
					
					
					// calcul taux part fixe _ nombre de personne
					PdfPTable tablePart= new PdfPTable (3);
					PdfPCell cell1 = new PdfPCell (new Phrase("Taux Part fixe"));
					PdfPCell cell2 = new PdfPCell (new Phrase("Nombre de personnes"));
					PdfPCell cell3 = new PdfPCell (new Phrase(" TotalHT "));					
					tablePart.addCell(cell1);
					tablePart.addCell(cell2);
					tablePart.addCell(cell3);
					
					PdfPCell cell4 = new PdfPCell (new Phrase(""+tarif));
					PdfPCell cell5 = new PdfPCell (new Phrase(""+nombreUsager));
					PdfPCell cell6 = new PdfPCell (new Phrase(""+totalPart));
					tablePart.addCell(cell4);
					tablePart.addCell(cell5);
					tablePart.addCell(cell6);
					tablePart.setSpacingAfter(20);
					document.add(tablePart);
					
					lesPoubelles = h.getLesPoubelles();
					for (Poubelle p : lesPoubelles) {
						
						
						// calcul poubelle
						String codePoubelle = p.getIdPoubelle();
						TypeDechet typeDechet = p.getNature();
						String nature = typeDechet.getLibelle();
						double prixKg = typeDechet.getTarif();
						
						PdfPTable tablePoubelle= new PdfPTable (4);						
						PdfPCell cell11 = new PdfPCell (new Phrase("Poubelle : " + codePoubelle + " Nature des déchets : " + nature));
						cell11.setHorizontalAlignment (PdfPCell.ALIGN_CENTER);
						cell11.setColspan (4);
						tablePoubelle.addCell(cell11);
						
						PdfPCell cell7 = new PdfPCell (new Phrase("date de pesee"));
						PdfPCell cell8 = new PdfPCell (new Phrase("Nombre de kg"));
						PdfPCell cell9 = new PdfPCell (new Phrase("PrixHT"));
						PdfPCell cell10 = new PdfPCell (new Phrase("TotalHT"));
						tablePoubelle.addCell(cell7);
						tablePoubelle.addCell(cell8);
						tablePoubelle.addCell(cell9);
						tablePoubelle.addCell(cell10);
						
						ArrayList<Levee> lesLevees = p.getLesLevees(an, mois);

						double totalPoubelle = 0;

						for (Levee l : lesLevees) {
							dateFormat = new SimpleDateFormat("dd/MM/yyyy");
							String dateLevee = dateFormat.format(l.getLaDate());

							double poid = l.getPoids();
							double total = poid * prixKg;
							totalPoubelle = totalPoubelle + total;
							
							PdfPCell cell12 = new PdfPCell (new Phrase(""+dateLevee));
							PdfPCell cell13= new PdfPCell (new Phrase(""+poid));
							PdfPCell cell14= new PdfPCell (new Phrase(""+df2.format(prixKg)));
							PdfPCell cell15 = new PdfPCell (new Phrase(""+df2.format(total)));
							tablePoubelle.addCell(cell12);
							tablePoubelle.addCell(cell13);
							tablePoubelle.addCell(cell14);
							tablePoubelle.addCell(cell15);
						}
						totalHT = totalHT + totalPoubelle;;
						PdfPCell cell16 = new PdfPCell (new Phrase("TotalHT"));
						cell16.setHorizontalAlignment (PdfPCell.ALIGN_RIGHT);
						cell16.setColspan (3);
						PdfPCell cell17 = new PdfPCell (new Phrase(""+df2.format(totalPoubelle)));
						tablePoubelle.setSpacingAfter(20);
						tablePoubelle.addCell(cell16);
						tablePoubelle.addCell(cell17);
						document.add(tablePoubelle);
						
					}
					double montantTVA=0;
					// total habitation
					totalHT = totalHT+totalPart;
					montantTVA = totalHT * (TVA / 100);
					montantTotal = totalHT + montantTVA;
					
					PdfPTable tableTotal= new PdfPTable (4);
					PdfPCell cell18 = new PdfPCell (new Phrase("TotalHT"));
					cell18.setHorizontalAlignment (PdfPCell.ALIGN_RIGHT);
					cell18.setColspan (3);
					PdfPCell cell19 = new PdfPCell (new Phrase(""+df2.format(totalHT)));
					PdfPCell cell20 = new PdfPCell (new Phrase("Montant TVA  "));
					cell20.setHorizontalAlignment (PdfPCell.ALIGN_RIGHT);
					cell20.setColspan (3);
					PdfPCell cell21 = new PdfPCell (new Phrase(""+df2.format(montantTVA)));
					PdfPCell cell22 = new PdfPCell (new Phrase("Total à payer  "));
					cell22.setHorizontalAlignment (PdfPCell.ALIGN_RIGHT);
					cell22.setColspan (3);
					PdfPCell cell23 = new PdfPCell (new Phrase(""+df2.format(montantTotal)));
					tableTotal.setSpacingAfter(20);
					tableTotal.addCell(cell18);
					tableTotal.addCell(cell19);
					tableTotal.addCell(cell20);
					tableTotal.addCell(cell21);
					tableTotal.addCell(cell22);
					tableTotal.addCell(cell23);
					document.add(tableTotal);
					
					// fermeture du document, important pour transférer les données // au PdfWriter
					document.close ();
					// affichage sous adobe
					try {
						Runtime.getRuntime().exec("explorer.exe " + nomPdf);
						Facture f = new Facture(mois, an, Parametre.getNomFichier(h, mois, an), h.getIdHabitation());
						
						//System.out.println(f.toString());
						if(AccesData.ajouterControleFacture(f)){
							System.out.println("insertion effectuée");
						}
						else{
							System.out.println("insertion non-effectuée");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
}
