package com.vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.metier.TypeDechet;
import com.persistance.AccesData;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAjoutTypeDechet extends JPanel {
	private JLabel lblSaisieDunNouveau;
	private JLabel lblCodeTypeDchet;
	private JLabel lblLibelleDechet;
	private JLabel lblTarifAuKg;
	private JTextField txtCodeType;
	private JTextField txtLibDechet;
	private JTextField txtTarif;
	private JButton btnValider;
	private JButton btnAnnuler;

	/**
	 * Create the panel.
	 */
	public PanelAjoutTypeDechet() {
		setLayout(null);
		add(getLblSaisieDunNouveau());
		add(getLblCodeTypeDchet());
		add(getLblLibelleDechet());
		add(getLblTarifAuKg());
		add(getTxtCodeType());
		add(getTxtLibDechet());
		add(getTxtTarif());
		add(getBtnValider());
		add(getBtnAnnuler());

	}
	private JLabel getLblSaisieDunNouveau() {
		if (lblSaisieDunNouveau == null) {
			lblSaisieDunNouveau = new JLabel("Saisie d'un nouveau type d\u00E9chet :");
			lblSaisieDunNouveau.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSaisieDunNouveau.setBounds(121, 11, 216, 14);
		}
		return lblSaisieDunNouveau;
	}
	private JLabel getLblCodeTypeDchet() {
		if (lblCodeTypeDchet == null) {
			lblCodeTypeDchet = new JLabel("Code type d\u00E9chet :");
			lblCodeTypeDchet.setBounds(22, 72, 93, 14);
		}
		return lblCodeTypeDchet;
	}
	private JLabel getLblLibelleDechet() {
		if (lblLibelleDechet == null) {
			lblLibelleDechet = new JLabel("Libelle d\u00E9chet :");
			lblLibelleDechet.setBounds(22, 120, 93, 14);
		}
		return lblLibelleDechet;
	}
	private JLabel getLblTarifAuKg() {
		if (lblTarifAuKg == null) {
			lblTarifAuKg = new JLabel("Tarif au kg :");
			lblTarifAuKg.setBounds(22, 166, 93, 14);
		}
		return lblTarifAuKg;
	}
	private JTextField getTxtCodeType() {
		if (txtCodeType == null) {
			txtCodeType = new JTextField();
			txtCodeType.setBounds(171, 69, 150, 20);
			txtCodeType.setColumns(10);
		}
		return txtCodeType;
	}
	private JTextField getTxtLibDechet() {
		if (txtLibDechet == null) {
			txtLibDechet = new JTextField();
			txtLibDechet.setBounds(171, 117, 150, 20);
			txtLibDechet.setColumns(10);
		}
		return txtLibDechet;
	}
	private JTextField getTxtTarif() {
		if (txtTarif == null) {
			txtTarif = new JTextField();
			txtTarif.setText("");
			txtTarif.setBounds(171, 166, 150, 20);
			txtTarif.setColumns(10);
		}
		return txtTarif;
	}
	private JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// test de la saisie du code type
					if (txtCodeType.getText().length() == 3) {
						if ( AccesData.getTypeDechet(txtCodeType.getText()) == null) {
							// test de la saisie du libelle
							if (txtLibDechet.getText().equals("") != true) {
								// test de la saisie du tarif
								if (txtTarif.getText().equals("") != true) {
									try{
										Double.parseDouble(txtTarif.getText());
										
										TypeDechet type = new TypeDechet(txtCodeType.getText(), txtLibDechet.getText(),
												Double.parseDouble(txtTarif.getText()));
										if (AccesData.ajoutTypeDechet(type) == true) {
											afficheMessage("Ajout efectuer");
										} else {
											afficheMessage("Erreur lors de l'ajout");
										}
									}
									catch(NumberFormatException el){
										afficheMessage("Merci de renseigner un tarif valide!");
										txtTarif.setText("");
										txtTarif.requestFocus();
									}
								}
								// Si le tarif n'est pas saisis
								else {
									afficheMessage("Merci de renseigner un tarif valide!");
									txtTarif.requestFocus();
								}
							}
							// Si le libelle n'est pas saisis
							else {
								afficheMessage("Merci de renseigner un libelle valide !");
								txtLibDechet.requestFocus();
							}
						} else {
							afficheMessage("Le code type existe déja !!");
							txtLibDechet.requestFocus();
						}
					}
					// Si l'id n'est pas saisis
					else {
						afficheMessage("Merci de renseigner un code type valide!");
						txtCodeType.requestFocus();
					}
				}
			});
			btnValider.setBounds(111, 211, 89, 23);
		}
		return btnValider;
	}
	private JButton getBtnAnnuler() {
		if (btnAnnuler == null) {
			btnAnnuler = new JButton("Annuler");
			btnAnnuler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtCodeType.setText("");
					txtLibDechet.setText("");
					txtTarif.setText("");
					txtCodeType.requestFocus();
				}
			});
			btnAnnuler.setBounds(290, 211, 89, 23);
		}
		return btnAnnuler;
	}
	/**
	 * Affichage d'un message
	 */
	private void afficheMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}
