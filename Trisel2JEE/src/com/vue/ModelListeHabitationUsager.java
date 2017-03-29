package com.vue;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.metier.Habitation;
import com.metier.Usager;
import com.persistance.AccesData;

public class ModelListeHabitationUsager extends AbstractTableModel {
	private String[] entetes = {"idHabitation","adresseRueHab", "adresseVilleHab","cpHab"};
	private List<Habitation> listHabitation;
	
	public ModelListeHabitationUsager(String idUsager) {
		listHabitation = AccesData.getLesHabitations(idUsager);
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}
	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listHabitation.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
		case 0 :
			return listHabitation.get(rowIndex).getIdHabitation();
		case 1:
			return listHabitation.get(rowIndex).getAdrRueHab();
		case 2 :
			return listHabitation.get(rowIndex).getAdrVilleHab();
		case 3:
			return listHabitation.get(rowIndex).getCpHab();
			
			
		default:
			throw new IllegalArgumentException();

		
		}
	}

}
