package com.util;

import java.util.ArrayList;
import java.util.Date;

import com.metier.Habitation;
import com.metier.Levee;
import com.persistance.HabitationDAO;
import com.persistance.LeveeDAO;

public class testFacture {

	public void testFacture() {
		int an= 2015;
		int mois=7;
		HabitationDAO hDAO= new HabitationDAO() ;
		ArrayList<Habitation> lesHabitations = hDAO.retrieve() ;
		if (lesHabitations.size() != 0) {
			for(Habitation h : lesHabitations) {
				
				editionElementfacture(h, an, mois) ;
			}
		}
	}

	private void editionElementfacture(Habitation h, int an, int mois) {
		Date laDate;
		LeveeDAO lDAO = new LeveeDAO();
		ArrayList<Levee> lesLevees = lDAO.retrieve();
		for(Levee l: lesLevees){
			laDate = l.getLaDate();
			if(laDate.getYear() == an && laDate.getMonth() == mois){
			
			}

		}
		
	}
}
