package com.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usager")
public class Usager {
	@Id
	@Column(name = "idUsager")
	private String idUsager;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "adrRueUsager")
	private String adresseRueUsager;
	@Column(name = "adrVilleUsager")
	private String adresseVilleUsager;
	@Column(name = "cpUsager")
	private String cpUsager;
	@Column(name = "login")
	private String login;
	@Column(name = "mdp")
	private String mdp;
	@OneToMany
	@JoinColumn(name = "idUsager")
	private List<Habitation> lesHabitations;

	public Usager() {
		super();
	}

	public Usager(String idUsager, String nom, String prenom, String adresseRueUsager, String adresseVilleUsager,
			String cpUsager, String login, String mdp, List<Habitation> lesHabitations) {
		super();
		this.idUsager = idUsager;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseRueUsager = adresseRueUsager;
		this.adresseVilleUsager = adresseVilleUsager;
		this.cpUsager = cpUsager;
		this.login = login;
		this.mdp = mdp;
		this.lesHabitations = lesHabitations;
	}

	public void addHabitation(Habitation h) {
		lesHabitations.add(h);

	}

	public boolean supprHabitation(Habitation h) {

		return false;
	}

	public String getIdUsager() {
		return idUsager;
	}

	public void setIdUsager(String idUsager) {
		this.idUsager = idUsager;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresseRueUsager() {
		return adresseRueUsager;
	}

	public void setAdresseRueUsager(String adresseRueUsager) {
		this.adresseRueUsager = adresseRueUsager;
	}

	public String getAdresseVilleUsager() {
		return adresseVilleUsager;
	}

	public void setAdresseVilleUsager(String adresseVilleUsager) {
		this.adresseVilleUsager = adresseVilleUsager;
	}

	public String getCpUsager() {
		return cpUsager;
	}

	public void setCpUsager(String cpUsager) {
		this.cpUsager = cpUsager;
	}

	public List<Habitation> getLesHabitations() {
		return lesHabitations;
	}

	public void setLesHabitations(ArrayList<Habitation> lesHabitations) {
		this.lesHabitations = lesHabitations;
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

	@Override
	public String toString() {
		return "Usager [idUsager=" + idUsager + ", nom=" + nom + ", prenom=" + prenom + ", adresseRueUsager="
				+ adresseRueUsager + ", adresseVilleUsager=" + adresseVilleUsager + ", cpUsager=" + cpUsager + "]";
	}
}
