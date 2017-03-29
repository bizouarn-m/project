<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import= "com.metier.Usager" %>
<%@ page import= "com.metier.Habitation" %>
<%@ page import= "com.metier.Facture" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page import= "java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Liste des usagers avec habitations enregistrées</title>
		<%ArrayList<Usager> lesUsagers = (ArrayList<Usager>) request.getAttribute("lesUsagers");
		int nbusager = lesUsagers.size();
		int nbHabitation =0;
		int nbFacture=0;
		int i;%>
	</head>
	<body>
	<H1>Liste des usagers avec habitations enregistrées</H1>
	</br>
	
		<Table border=1>
		<tr>
			<td><b>nom usager</b></td>
			<td><b>prénom usager</b></td>
			<td><b>adresse rue logement</b></td>
			<td><b>code postal</b></td>
			<td><b>ville</b></td>
			<td><b>nombre facture</b></td>
		</tr>
		<% for(Usager u : lesUsagers)
		{
			i=0;
			if(u.getLesHabitations().size() == 0)
			{
				out.println("<td>"+u.getNom()+"</td>");
				out.println("<td>"+u.getPrenom()+"</td>");
				out.println("<td>Aucune habitation enregistée</td> ");
				out.println("<td></td>");
				out.println("<td></td>");
				out.println("<td> 0 </td>");
			}
			else
			{
				for(Habitation h : u.getLesHabitations())
					{
					nbHabitation = nbHabitation +1;
					%>
				<tr>
					<%
					if(i == 0){
						out.println("<td>"+u.getNom()+"</td>");
						out.println("<td>"+u.getPrenom()+"</td>");
						i = i+1;
					}
					else{
						out.println("<td></td>");
						out.println("<td></td>");
					}				
					out.println("<td>"+h.getAdrRueHab()+"</td>");
					out.println("<td>"+h.getCpHab()+"</td>");
					out.println("<td>"+h.getAdrVilleHab()+"</td>");
					out.println("<td>"+h.getLesFactures().size()+"</td>");
					nbFacture = nbFacture + h.getLesFactures().size();
					%>
				</tr>
				<%}
			}
		}%>
		</Table>
		
		
		<p>Récapitulatif : </br>
		<%
		out.println(" Nombre d'usager : "+nbusager+"</br>");
		out.println(" Nombre d'habitation : "+nbHabitation+"</br>");
		out.println(" Nombre de facture : "+nbFacture+"</br>");
		%></p>
	</body>
</html>