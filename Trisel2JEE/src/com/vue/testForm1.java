package com.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import com.metier.Utilisateur;
import com.persistance.AccesData;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class testForm1 extends JFrame {

	private JPanel p;
	private JMenuBar menuBar;
	private JMenu mnFichier;
	private JMenuItem mntmQuiter;
	private JMenu mnLevee;
	private JMenuItem mntmInsertionLeve;
	private JMenu mnFacture;
	private JMenuItem mntmGnrationFacture;
	private JTextField login;
	private JLabel lblLogin;
	private JLabel lblMotDePasse;
	private JButton btnValider;
	private JPasswordField mdp;
	private JMenu mnConsultation;
	private JMenuItem mntmHabitationParUsager;
	private JMenu mnDonnesDeBase;
	private JMenu mnTypedechet;
	private JMenuItem mntmAjout;
	private JMenuItem mntmChangementTarif;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testForm1 frame = new testForm1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testForm1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Gestion poubelles");

		setJMenuBar(getMenuBar_1());
		p = new JPanel();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		p.add(getLogin());
		p.add(getLblLogin());
		p.add(getLblMotDePasse());
		p.add(getBtnValider());
		p.add(getMdp());
		mntmGnrationFacture.setEnabled(false);
		mntmInsertionLeve.setEnabled(false);
		mntmHabitationParUsager.setEnabled(false);
		mntmAjout.setEnabled(false);
		mntmChangementTarif.setEnabled(false);

	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFichier());
			menuBar.add(getMnLevee());
			menuBar.add(getMnFacture());
			menuBar.add(getMnConsultation());
			menuBar.add(getMnDonnesDeBase());
		}
		return menuBar;
	}

	private JMenu getMnFichier() {
		if (mnFichier == null) {
			mnFichier = new JMenu("Fichier");
			mnFichier.add(getMntmQuiter());
		}
		return mnFichier;
	}

	private JMenuItem getMntmQuiter() {
		if (mntmQuiter == null) {
			mntmQuiter = new JMenuItem("Quiter");
			mntmQuiter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return mntmQuiter;
	}

	private JMenu getMnLevee() {
		if (mnLevee == null) {
			mnLevee = new JMenu("Lev\u00E9e");
			mnLevee.add(getMntmInsertionLeve());
		}
		return mnLevee;
	}

	private void insertionLevee() {
		// on affecte le panel de la fenêtre
		// avec une instance de PanelLevee
		this.setContentPane(new PanelLevee());
		// mets à jour le formulaire
		this.revalidate();
	}

	private JMenuItem getMntmInsertionLeve() {
		if (mntmInsertionLeve == null) {
			mntmInsertionLeve = new JMenuItem("Insertion lev\u00E9e");
			mntmInsertionLeve.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertionLevee();
				}
			});
		}
		return mntmInsertionLeve;
	}

	private JMenu getMnFacture() {
		if (mnFacture == null) {
			mnFacture = new JMenu("Facture");
			mnFacture.add(getMntmGnrationFacture());
		}
		return mnFacture;
	}

	private void generationfacture() {
		// on affecte le panel de la fenêtre
		// avec une instance de PanelEditionFacture
		this.setContentPane(new PanelEditionFacture());
		// mets à jour le formulaire
		this.revalidate();
	}

	private JMenuItem getMntmGnrationFacture() {
		if (mntmGnrationFacture == null) {
			mntmGnrationFacture = new JMenuItem("G\u00E9n\u00E9ration Facture");
		}
		mntmGnrationFacture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generationfacture();
			}
		});
		return mntmGnrationFacture;
	}

	private JTextField getLogin() {
		if (login == null) {
			login = new JTextField();
			login.setBounds(158, 50, 86, 20);
			login.setColumns(10);
		}
		return login;
	}

	private JLabel getLblLogin() {
		if (lblLogin == null) {
			lblLogin = new JLabel("Login :");
			lblLogin.setBounds(62, 53, 46, 14);
		}
		return lblLogin;
	}

	private JLabel getLblMotDePasse() {
		if (lblMotDePasse == null) {
			lblMotDePasse = new JLabel("Mot de passe :");
			lblMotDePasse.setBounds(62, 103, 86, 14);
		}
		return lblMotDePasse;
	}

	private JButton getBtnValider() {
		if (btnValider == null) {
			btnValider = new JButton("Valider");
			btnValider.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Utilisateur u = AccesData.getUtilisateur(login.getText(), new String(mdp.getPassword()));
					if (u != null) {
						//afficheMessage("Authentification ok");
						paramNiveau(u.getNiveau());
						affichageFondEcran(u.getNomUtilisateur());

					} else {
						afficheMessage("Authentification erronée");
						login.requestFocus();
					}
				}

			});
			btnValider.setBounds(158, 148, 89, 23);
		}
		return btnValider;
	}

	/**
	 * Droits d'acces celon le niveau de l'utilisateur
	 */
	private void paramNiveau(int niveau) {
		switch (niveau) {
		case 1:
			mntmGnrationFacture.setEnabled(true);
			mntmInsertionLeve.setEnabled(true);
			mntmHabitationParUsager.setEnabled(true);
			mntmAjout.setEnabled(true);
			mntmChangementTarif.setEnabled(true);
			break;
		case 2:
			mntmGnrationFacture.setEnabled(true);
			break;
		case 3:
			mntmInsertionLeve.setEnabled(true);
			break;
		default:
			break;

		}

	}

	/**
	 * Affichage d'un message
	 */
	private void afficheMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	private JPasswordField getMdp() {
		if (mdp == null) {
			mdp = new JPasswordField();
			mdp.setBounds(158, 100, 86, 20);
		}
		return mdp;
	}

	/**
	 * Affichage de l'écran d'aceuil
	 */
	private void affichageFondEcran(String nomUtilisateur) {
		this.setContentPane(new PanelFondEcran(nomUtilisateur));
		this.revalidate();

	}

	private JMenu getMnConsultation() {
		if (mnConsultation == null) {
			mnConsultation = new JMenu("Consultation");
			mnConsultation.add(getMntmHabitationParUsager());
		}
		return mnConsultation;
	}

	private void habitationParUsager() {
		// on affecte le panel de la fenêtre
		this.setContentPane(new PanelHabParUsager());
		// mets à jour le formulaire
		this.revalidate();
	}

	private JMenuItem getMntmHabitationParUsager() {
		if (mntmHabitationParUsager == null) {
			mntmHabitationParUsager = new JMenuItem("Habitation par usager");
			mntmHabitationParUsager.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					habitationParUsager();
				}
			});
		}
		return mntmHabitationParUsager;
	}

	private JMenu getMnDonnesDeBase() {
		if (mnDonnesDeBase == null) {
			mnDonnesDeBase = new JMenu("Donn\u00E9es de base");
			mnDonnesDeBase.add(getMnTypedechet());
		}
		return mnDonnesDeBase;
	}

	private JMenu getMnTypedechet() {
		if (mnTypedechet == null) {
			mnTypedechet = new JMenu("TypeDechet");
			mnTypedechet.add(getMntmAjout());
			mnTypedechet.add(getMntmChangementTarif());
		}
		return mnTypedechet;
	}

	private void ajoutTypeDechet() {
		// on affecte le panel de la fenêtre
		this.setContentPane(new PanelAjoutTypeDechet());
		// mets à jour le formulaire
		this.revalidate();
	}

	private JMenuItem getMntmAjout() {
		if (mntmAjout == null) {
			mntmAjout = new JMenuItem("Ajout");
			mntmAjout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ajoutTypeDechet();
				}
			});
		}
		return mntmAjout;
	}
	private void modifTypeDechet() {
		// on affecte le panel de la fenêtre
		this.setContentPane(new PanelMiseAJourTarif());
		// mets à jour le formulaire
		this.revalidate();
	}
	private JMenuItem getMntmChangementTarif() {
		if (mntmChangementTarif == null) {
			mntmChangementTarif = new JMenuItem("Changement tarif");
			mntmChangementTarif.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						modifTypeDechet();
				}
			});
		}
		return mntmChangementTarif;
	}
}
