package com.metier;

import java.util.Date;

public class Camion {
	private String immatriculation;
	private Date dateDeMiseEnCirculation;
	
	public Camion(String immatriculation, Date dateDeMiseEnCirculation) {
		super();
		this.immatriculation = immatriculation;
		this.dateDeMiseEnCirculation = dateDeMiseEnCirculation;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public Date getDateDeMiseEnCirculation() {
		return dateDeMiseEnCirculation;
	}
	public void setDateDeMiseEnCirculation(Date dateDeMiseEnCirculation) {
		this.dateDeMiseEnCirculation = dateDeMiseEnCirculation;
	}
	
}
