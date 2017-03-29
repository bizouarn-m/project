package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metier.Habitation;
import com.metier.Usager;
import com.persistance.AccesData;

/**
 * Servlet implementation class Authentification
 */
@WebServlet("/Authentification")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("vue/authentification.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// on récupère les données du formulaire
		String user = request.getParameter("user");
		String mdp = request.getParameter("mdp");
		// on fait appel au modèle pour récupérer l'éventuel usager
		Usager usag = AccesData.getUsager(user, mdp);
		if (usag == null) {
			// on définit le message d'erreur
			String message = "Authentification incorrecte";
			// on rappelle la serveur en méthode get en lui passant en paramètre
			// le message
			response.sendRedirect("./Authentification?message=" + message);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("usag", usag);
			response.sendRedirect("./MenuGeneral");
		}
	
	}

}
