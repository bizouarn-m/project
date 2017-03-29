package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

	@Id
	@Column(name = "idUtilisateur")
	private String idUtilisateur;
	@Column(name = "nomUtilisateur")
	private String nomUtilisateur;
	@Column(name = "prenomUtilisateur")
	private String prenomUtilisateur;
	@Column(name = "login")
	private String login;
	@Column(name = "mdp")
	private String mdp;
	@Column(name = "niveau")
	private int niveau;

	public Utilisateur(String idUtilisateur, String nomUtilisateur, String prénomUtilisateur, String login, String mdp,
			int niveau) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prénomUtilisateur;
		this.login = login;
		this.mdp = mdp;
		this.niveau = niveau;
	}
	public Utilisateur() {
		super();
	}
	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrénomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrénomUtilisateur(String prénomUtilisateur) {
		this.prenomUtilisateur = prénomUtilisateur;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", prenomUtilisateur=" + prenomUtilisateur + ", login=" + login + ", mdp=" + mdp + ", niveau="
				+ niveau + "]";
	}

}
