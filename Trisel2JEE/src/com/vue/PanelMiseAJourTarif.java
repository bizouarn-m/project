package com.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.metier.TypeDechet;
import com.metier.Usager;
import com.persistance.AccesData;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelMiseAJourTarif extends JPanel {
	private JLabel lblMiseJour;
	private JLabel lblTypeDchet;
	private JLabel lblTarifActuel;
	private JLabel lblNouveauTarif;
	private JTextField newTarif;
	private JTextField tarifActuel;
	private JComboBox cbxTypeD;
	private JButton valider;
	private JButton annuler;
	private List<TypeDechet> lesTypeDechet;

	/**
	 * Create the panel.
	 */
	public PanelMiseAJourTarif() {
		lesTypeDechet= AccesData.getTypeDechet();
		setLayout(null);
		add(getLblMiseJour());
		add(getLblTypeDchet());
		add(getLblTarifActuel());
		add(getLblNouveauTarif());
		add(getNewTarif());
		add(getTarifActuel());
		add(getCbxTypeD());
		add(getValider());
		add(getAnnuler());

	}
	private JLabel getLblMiseJour() {
		if (lblMiseJour == null) {
			lblMiseJour = new JLabel("Mise \u00E0 jour tarif par typede d\u00E9chet");
			lblMiseJour.setBounds(107, 11, 242, 25);
		}
		return lblMiseJour;
	}
	private JLabel getLblTypeDchet() {
		if (lblTypeDchet == null) {
			lblTypeDchet = new JLabel("Type d\u00E9chet :");
			lblTypeDchet.setBounds(43, 85, 67, 14);
		}
		return lblTypeDchet;
	}
	private JLabel getLblTarifActuel() {
		if (lblTarifActuel == null) {
			lblTarifActuel = new JLabel("Tarif actuel :");
			lblTarifActuel.setBounds(44, 130, 66, 14);
		}
		return lblTarifActuel;
	}
	private JLabel getLblNouveauTarif() {
		if (lblNouveauTarif == null) {
			lblNouveauTarif = new JLabel("Nouveau tarif :");
			lblNouveauTarif.setBounds(43, 169, 86, 14);
		}
		return lblNouveauTarif;
	}
	private JTextField getNewTarif() {
		if (newTarif == null) {
			newTarif = new JTextField();
			newTarif.setBounds(155, 166, 153, 20);
			newTarif.setColumns(10);
		}
		return newTarif;
	}
	private JTextField getTarifActuel() {
		if (tarifActuel == null) {
			tarifActuel = new JTextField();
			tarifActuel.setBounds(155, 127, 153, 20);
			tarifActuel.setColumns(10);
		}
		return tarifActuel;
	}
	private JComboBox getCbxTypeD() {
		if (cbxTypeD == null) {
			cbxTypeD = new JComboBox();
			cbxTypeD.setBounds(155, 82, 153, 17);
			for(TypeDechet td : lesTypeDechet){
				cbxTypeD.addItem(td.getTypeDechet()+" "+td.getLibelle());			
			}
			cbxTypeD.setSelectedIndex(0);
		}
		return cbxTypeD;
	}
	private JButton getValider() {
		if (valider == null) {
			valider = new JButton("Valider");
			valider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			valider.setBounds(68, 233, 89, 23);
		}
		return valider;
	}
	private JButton getAnnuler() {
		if (annuler == null) {
			annuler = new JButton("Annuler");
			annuler.setBounds(275, 233, 89, 23);
		}
		return annuler;
	}
}
