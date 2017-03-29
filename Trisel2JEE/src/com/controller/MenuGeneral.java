package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuGeneral
 */
@WebServlet("/MenuGeneral")
public class MenuGeneral extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuGeneral() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("vue/menu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// on récupère l'action sélectionnée par l'utilisateur
		String action=request.getParameter("action");
		// traitement de l'action
		// appel de la servlet correspondante
		switch(action)
		{
			case "ServScript":
			{
				request.getRequestDispatcher("vue/habitation.jsp").forward(request, response);
				break;
			}

			case "ServJslt":
			{
				request.getRequestDispatcher("vue/habitationJSLT.jsp").forward(request, response);
				break;
			}
			case "ServList":
			{
				request.getRequestDispatcher("vue/habitationListe.jsp").forward(request, response);
				break;
			}
			default :
				response.sendRedirect("./MenuGeneral");
				break;
		}
	}

}


