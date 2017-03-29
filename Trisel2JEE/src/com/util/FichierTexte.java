package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Classe pour manipuler les fichiers textes en lecture et en ecriture
 * @author bizouarn-m
 */
public class FichierTexte {
	// buffer de lecture
	private BufferedReader br;
	// buffer d'écriture
	private BufferedWriter bw;
	public FichierTexte()
	{
		br=null;
		bw=null;
	}
	// ouverture du fichier en lecture
	/**
	 * Ouvre un fichier en lecture
	 * @param nom
	 * on donne le fichier concerné
	 * @return
	 * true si l'ouverture a reusit, false sinon
	 */
	public boolean openFileReader(String nom)
	{
		boolean open;
		FileInputStream fichier=null;
		String ligne=null;
		try
		{
			fichier=new FileInputStream(new File(nom));
			br=new BufferedReader(new InputStreamReader(fichier));
			open=true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("pb ouverture");
			open=false;
		}
		return open;
	}
	// ouverture du fichier en écriture
	/**
	 * Ouverture du fichier en écriture
	 * @param nom
	 * on donne le fichier concerné
	 * @return
	 * true si l'ecriture a reusit, false sinon
	 */
	public boolean openFileWriter(String nom)
	{ 
		boolean open;
		FileOutputStream fichier=null;
		try
		{
			fichier=new FileOutputStream(nom);
			bw=new BufferedWriter(new OutputStreamWriter(fichier));
			open=true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("pb ouverture");
			open=false;
		}
		return open;
	}
	// fermeture du flux d'écriture
	/**
	 * Fermeture du flux d'écriture
	 * @return
	 * true si la fermeture s'est faite, false sinon
	 */
	public boolean closeFileWriter()
	{
		boolean ok = true;
		try
		{
			bw.close();
		}
		catch (IOException e)
		{
			ok = false;
		}
		return ok;
	}
// fermeture du flux de lecture
	/**
	 * Fermeture du flux de lecture
	 */
	public void closeFileReader()
	{
		try
		{
			br.close();}
		catch (IOException e)
		{
			System.out.println("pb fermeture");
		}
	}
	// écriture d'une ligne
	/**
	 * Ecriture d'une ligne
	 * @param ligne
	 * ligne à ajouter
	 */
	public void writeLigne(String ligne)
	{
		try
		{
			bw.write(ligne+"\n");
		}
		catch (IOException e)
		{
			System.out.println("pb ecriture");
		}
	}
	// lecture d'une ligne
	/**
	 * Lecture d'une ligne
	 * @return
	 * ligne récupérer
	 */
	public String readLigne()
	{
		String ligne=null;
		try
		{
			ligne= br.readLine();
		}
		catch (IOException e)
		{
			System.out.println("pb lecture");
		}
		return ligne;
	}
}