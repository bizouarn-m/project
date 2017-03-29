package com.vue;

import javax.swing.JPanel;

import com.metier.Usager;
import com.persistance.AccesData;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class PanelHabParUsager extends JPanel {
	private JLabel lblSlctionnerLusager;
	private JComboBox comboBox;
	private List<Usager> lesUsagers;
	private ModelListeHabitationUsager model;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public PanelHabParUsager() {
		lesUsagers =AccesData.getUsager();
		setLayout(null);
		add(getLblSlctionnerLusager());
		add(getScrollPane());
		add(getComboBox());
		
		

	}
	private JLabel getLblSlctionnerLusager() {
		if (lblSlctionnerLusager == null) {
			lblSlctionnerLusager = new JLabel("S\u00E9l\u00E9ctionner l'usager :");
			lblSlctionnerLusager.setBounds(24, 36, 134, 14);
		}
		return lblSlctionnerLusager;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(168, 33, 207, 20);
			//instantiation des usagers
			for(Usager u : lesUsagers){
				comboBox.addItem(u.getIdUsager()+"-"+u.getNom()+" "+u.getPrenom());			
			}
			comboBox.setSelectedIndex(0);
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(comboBox.getSelectedIndex()!=-1){
						model = new ModelListeHabitationUsager(lesUsagers.get(comboBox.getSelectedIndex()).getIdUsager());
						table.setModel(model);
						
						if(lesUsagers.get(comboBox.getSelectedIndex()).getLesHabitations().size() == 0){
							afficheMessage("pas d'habitation pour l'usager");
						}
						table.revalidate();
					}
				}
			});
		}
		return comboBox;
	}
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.setBounds(57, 101, 287, 109);
		}
		return table;
	}
	private void afficheMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(53, 91, 337, 153);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
}
