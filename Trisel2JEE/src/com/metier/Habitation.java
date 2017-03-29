package com.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="habitation")
public class Habitation {
	@Id
	@Column(name="idHabitation")
	private String idHabitation;
	@Column(name="adrRueHab")
	private String adrRueHab;
	@Column(name="adrVilleHab")
	private String adrVilleHab;
	@Column(name="cpHab")
	private String cpHab;
	@Column(name="nbPersonne")
	private int nbPersonne;
	@ManyToOne
	@JoinColumn(name="idUsager")
	private Usager usager;
	@OneToMany
	@JoinColumn(name="idHabitation")
	private List<Poubelle> lesPoubelles;
	@OneToMany
	@JoinColumn(name="idHabitation")
	private List<Facture> lesFactures;
	
	public Habitation(String idHabitation, String adresseRueHab, String adresseVilleHab, String cpHab, int nbPersonne, Usager usager) {
		super();
		this.idHabitation = idHabitation;
		this.adrRueHab = adresseRueHab;
		this.adrVilleHab = adresseVilleHab;
		this.cpHab = cpHab;
		this.nbPersonne = nbPersonne;
		this.usager = usager;
		this.lesPoubelles = new ArrayList<Poubelle>();
		this.lesFactures = new ArrayList<Facture>();
	}
	public Habitation() {
		super();
	}

	public List<Facture> getLesFactures() {
		return lesFactures;
	}

	public void setLesFactures(ArrayList<Facture> lesFactures) {
		this.lesFactures = lesFactures;
	}
	public void addFacture(Facture f)
	{
		lesFactures.add(f);
	}
	public String getAdrRueHab() {
		return adrRueHab;
	}
	public void setAdrRueHab(String adresseRueHab) {
		this.adrRueHab = adresseRueHab;
	}
	public List<Poubelle> getLesPoubelles() {
		return lesPoubelles;
	}
	public void setLesPoubelles(ArrayList<Poubelle> lesPoubelles) {
		this.lesPoubelles = lesPoubelles;
	}
	public Usager getUsager() {
		return usager;
	}
	public void setUsager(Usager usager) {
		this.usager = usager;
	}
	public String getIdHabitation() {
		return idHabitation;
	}
	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}

	public String getAdrVilleHab() {
		return adrVilleHab;
	}
	public void setAdrVilleHab(String adresseVilleHab) {
		this.adrVilleHab = adresseVilleHab;
	}
	public String getCpHab() {
		return cpHab;
	}
	public void setCpHab(String cpHab) {
		this.cpHab = cpHab;
	}
	public int getNbPersonne() {
		return nbPersonne;
	}
	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}
	public String toString() {
		return "Habitation [idHabitation=" + idHabitation + ", adresseRueHab=" + adrRueHab + ", adresseVilleHab="
				+ adrVilleHab + ", cpHab=" + cpHab + ", nbPersonne=" + nbPersonne + ", usager=" + usager
				+ ", lesPoubelles=" + lesPoubelles + "]";
	}
	public void addPoubelle(Poubelle p)
	{
		lesPoubelles.add(p);
	}
	
	public double getCout(int an, int mois)
	{
		double cout = 0;
		for (Poubelle p  : lesPoubelles)
		{
			cout = cout + p.getCout(an, mois);
		}
		return cout;
	}
}
