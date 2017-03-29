package com.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typeDechet")

public class TypeDechet {
	@Id
	@Column(name="idTypeDechet")
	private String typeDechet;
	@Column(name="libelle")
	private String libelle;
	@Column(name="tarif")
	private Double tarif;
	
	public TypeDechet(String typeDechet, String libelle, Double tarif) {
		super();
		this.typeDechet = typeDechet;
		this.libelle = libelle;
		this.tarif = tarif;
	}
	public TypeDechet() {
		super();
	}
	public String getTypeDechet() {
		return typeDechet;
	}
	public void setTypeDechet(String typeDechet) {
		this.typeDechet = typeDechet;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Double getTarif() {
		return tarif;
	}
	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}
	@Override
	public String toString() {
		return "TypeDechet [typeDechet=" + typeDechet + ", libelle=" + libelle + ", tarif=" + tarif + "]";
	}
}
