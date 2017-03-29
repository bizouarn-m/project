package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metier.Facture;
import com.metier.Habitation;
import com.persistance.AccesData;

/**
 * Servlet implementation class Habitation
 */
@WebServlet("/Habitation")
public class HabitationAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HabitationAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// contenu réponse au format html
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		// récupération idHabitation sélectionné
		String reponse;
		String idHabitation = request.getParameter("valeur");
		 // récupération de l'habitation sélectionnée
		Habitation h = AccesData.getUneHabitation(idHabitation);
		List<Facture> listeFacture=h.getLesFactures();
		reponse ="<p>pour le logement  ";
		reponse = reponse +   h.getAdrRueHab() + " " + h.getCpHab() + " " + h.getAdrVilleHab() + "</p>" ;
		if (listeFacture.size() == 0)
			{
			reponse = reponse + " Aucune facture disponible</br>";
			}
			else {
			reponse = reponse + "Liste des factures</br>";
			// parcours des factures et affichage dans un tableau
			 for(Facture f : listeFacture) {
			     	reponse = reponse + "<table border='1'>";
				reponse = reponse + "<tr><th>liste des factures</th></tr>";
				reponse = reponse + "<tr>"; 
				String lienFacture ="pdf/" + f.getNomFacture();
				String nomFacture = f.getNomFacture();
				reponse = reponse + "<td><a href="+ lienFacture;
				reponse = reponse +" target='_blank'><img src='img/logoadobe.png'>" + nomFacture +"</a></td>";
				reponse = reponse + "</tr>";
				reponse = reponse + "</table>";
				   }
					}
				// renvoie de la réponse
				response.getWriter().write(reponse);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
