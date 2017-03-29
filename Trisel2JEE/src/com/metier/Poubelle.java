package com.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="poubelle")
public class Poubelle {
	@Id
	@Column(name="idPoubelle")
	private String idPoubelle;
	@Column(name="idHabitation")
	private String idHabitation;
	@ManyToOne
	@JoinColumn(name="idTypeDechet")
	private TypeDechet nature;
	@OneToMany
	@JoinColumn(name="idPoubelle")
	private List<Levee> lesLevee;

	
	public Poubelle(String idPoubelle, String idHabitation, TypeDechet nature) {
		super();
		this.idPoubelle = idPoubelle;
		this.idHabitation = idHabitation;
		this.nature = nature;
		this.lesLevee = new ArrayList<Levee>();
	}

	public Poubelle() {
		super();
	}

	public List<Levee> getLesLevee() {
		return lesLevee;
	}

	public void setLesLevee(ArrayList<Levee> lesLevee) {
		this.lesLevee = lesLevee;
	}

	public String getIdHabitation() {
		return idHabitation;
	}

	public void setIdHabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}
	public TypeDechet getNature() {
		return nature;
	}

	public void setNature(TypeDechet nature) {
		this.nature = nature;
	}


	public String getIdPoubelle() {
		return idPoubelle;
	}

	public void setIdPoubelle(String idPoubelle) {
		this.idPoubelle = idPoubelle;
	}
	public void addLevee(Levee l)
	{
		lesLevee.add(l);

	}
	public ArrayList<Levee> getLesLevees(int an, int mois)
	{
		ArrayList<Levee> listeLevee;
		listeLevee = new ArrayList<Levee>();
		//System.out.println(lesLevee.size());
		for (Levee l : lesLevee)
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(l.getLaDate());
			//extraction du mois et de l'année
			int moisL = cal.get(Calendar.MONTH)+1;
			//System.out.println(moisL);
			int anL = cal.get(Calendar.YEAR);
			//System.out.println(anL);
			if ((moisL == mois)&& (anL == an))
			{
				listeLevee.add(l);
			}
		}
		return listeLevee;
	}
	public double getCout(int an, int mois)
	{
		double cout = 0;
		ArrayList<Levee> listeLevee = this.getLesLevees(an,mois);
		//System.out.println(lesLevee.size());
		for (Levee l  : listeLevee)
		{
			//System.out.println(l.getPoids());
			cout = cout + (l.getPoids()) * (nature.getTarif());
		}
		return cout;
	}

	@Override
	public String toString() {
		return "Poubelle [idPoubelle=" + idPoubelle + ", idHabitation=" + idHabitation + ", nature=" + nature
				+ ", lesLevee=" + lesLevee + "]";
	}
	
}
