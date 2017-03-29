package com.vue;

import javax.swing.JPanel;

import com.metier.Habitation;
import com.pdf.EditionFacture;
import com.persistance.AccesData;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEditionFacture extends JPanel implements PropertyChangeListener {
		private JMonthChooser monthChooser;
		private JYearChooser yearChooser;
		private JButton btnLancerdition;

		private int an;
		private int mois;
		private Calendar calendar;

		/**
		 * Create the panel.
		 */
		public PanelEditionFacture() {
			setLayout(null);
			add(getMonthChooser());
			add(getYearChooser());
			add(getBtnLancerdition());

			// récupération année et mois actuel
			calendar = Calendar.getInstance();
			an = getYear();
			mois = getMonth() + 1;// + 1 car mois de 0 à 11 et non pas de 1 = 12
			monthChooser = new JMonthChooser();
			monthChooser.addPropertyChangeListener(this);

		}

		private JMonthChooser getMonthChooser() {
			if (monthChooser == null) {
				monthChooser = new JMonthChooser();
				monthChooser.setBounds(80, 116, 97, 20);
			}
			return monthChooser;
		}

		private JYearChooser getYearChooser() {
			if (yearChooser == null) {
				yearChooser = new JYearChooser();
				yearChooser.setBounds(275, 116, 47, 20);
			}
			return yearChooser;
		}

		private JButton getBtnLancerdition() {
			if (btnLancerdition == null) {
				btnLancerdition = new JButton("Lancer \u00E9dition");
				btnLancerdition.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						List<Habitation> listeHab = AccesData.getHabitation();
						for(Habitation h : listeHab){
							EditionFacture.editionElementfacture(h, an, mois);
						}
						afficheMessage("Edition des factures effectuée");
					}
				});
				btnLancerdition.setBounds(163, 181, 128, 38);
			}
			return btnLancerdition;
		}

		public int getYear() {
			return calendar.get(Calendar.YEAR);
		}

		public int getMonth() {
			return calendar.get(Calendar.MONTH);
		}

		// procédure de tests des sources d'évènement
		public void propertyChange(PropertyChangeEvent evt) {
			if (evt.getPropertyName().equals("year")) {
				an = (Integer) evt.getNewValue();
			}
			if (evt.getPropertyName().equals("month")) {
				mois = (Integer) evt.getNewValue() + 1;
			}
		}
		private void afficheMessage(String message)
		{
			JOptionPane.showMessageDialog(null,message);
		}

	}
