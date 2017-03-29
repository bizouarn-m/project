package com.vue;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import com.util.InsertionLeves;
import com.util.Parametre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PanelLevee extends JPanel {
	private JButton btnLancer;
	private JLabel nbLevee;

	/**
	 * Create the panel.
	 */
	public PanelLevee() {
		setLayout(null);
		add(getBtnLancer());
		add(getNbLevee());

	}
	private JLabel getNbLevee() {
		if (nbLevee == null) {
			String textelabel = " Il y a  " + Parametre.nblevee() + " fichier(s) à traiter";
			nbLevee = new JLabel(textelabel);
			nbLevee.setBounds(156, 87, 154, 14);

		}
		return nbLevee;
	}
	private JButton getBtnLancer() {
		if (btnLancer == null) {
			btnLancer = new JButton("Lancer");
			
			btnLancer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InsertionLeves.traitementLevee();
					afficheMessage("Mise à jour effectuée");
					
					btnLancer.setEnabled(false);
					int nb =Parametre.nblevee();
					String textelabel = " Il y a  " + Parametre.nblevee() + " fichier(s) à traiter";
					nbLevee = new JLabel(textelabel);
				}
			});
			
			btnLancer.setBounds(178, 134, 89, 23);
		}
		if(Parametre.nblevee()==0){
			btnLancer.setEnabled(false);
		}
		return btnLancer;
	}

	private void afficheMessage(String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
}
