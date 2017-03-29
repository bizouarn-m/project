package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="facture")
public class Facture {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idFacture")
	private int idFacture;
	@Column(name="moisF")
	private int mois;
	@Column(name="anF")
	private int ans;
	@Column(name="nomFacture")
	private String nomFacture;
	@Column(name="idHabitation")
	private String idHabitation;
	 
	public Facture(int mois, int ans, String nomFacture, String idHabitation) {
		super();
		this.mois = mois;
		this.ans = ans;
		this.nomFacture = nomFacture;
		this.idHabitation = idHabitation;
	}
	
	public Facture(int idFacture, int mois, int ans, String nomFacture, String idHabitation) {
		super();
		this.idFacture = idFacture;
		this.mois = mois;
		this.ans = ans;
		this.nomFacture = nomFacture;
		this.idHabitation = idHabitation;
	}
	public Facture() {
		super();
	}


	public String getIdHabitation() {
		return idHabitation;
	}

	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}

	public Facture(int idFacture, int mois, int ans, String nomFacture) {
		super();
		this.idFacture = idFacture;
		this.mois = mois;
		this.ans = ans;
		this.nomFacture = nomFacture;
	}

	public int getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getAns() {
		return ans;
	}

	public void setAns(int ans) {
		this.ans = ans;
	}

	public String getNomFacture() {
		return nomFacture;
	}

	public void setNomFacture(String nomFacture) {
		this.nomFacture = nomFacture;
	}

	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", mois=" + mois + ", ans=" + ans + ", nomFacture=" + nomFacture
				+ ", idHabitation=" + idHabitation + "]";
	}

	
	 
	 
}
