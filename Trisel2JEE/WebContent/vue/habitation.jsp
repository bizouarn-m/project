<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "com.metier.Habitation" %>
<%@ page import= "com.metier.Facture" %>
<%@ page import= "com.metier.Usager" %>
<%@ page import= "java.util.List" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset=\ "utf-8\" />
		<title>Affichage factures</title>
	</head>

	<body>
	<%Usager usag = (Usager) request.getSession().getAttribute("usag");
	 List <Habitation> listeHabitation = usag.getLesHabitations();%>
	
		<p><a href='./MenuGeneral'> Retour Menu General</a> 
		<!--  // affichage nom et prenom de l'usager -->
		 <% out.println("<h1>");
		 out.println(usag.getNom() + " " + usag.getPrenom());
		out.println("</h1>");%>
			
		<!--parcours des habitations--> 
		<% if (listeHabitation.size() == 0) {
			out.println("Aucune habitation connue ");
		} else { 
			for (Habitation h : listeHabitation) { 
				out.println(" <p>pour le logement situé à</p> ");
				out.println(h.getAdrRueHab() + " <br /> ");
				out.println(h.getCpHab() + " " + h.getAdrVilleHab() + "<br /> ");
	 			List <Facture> listeFacture = h.getLesFactures(); 
	 			if(listeFacture.size() != 0) { 
	 				for (Facture f : listeFacture) {
						out.println("<table border='1'>");%>
							<tr>
								<th>liste des factures</th>
							</tr>
							<tr>
								<% String lienFacture = "pdf/" + f.getNomFacture(); 
								String nomFacture = f.getNomFacture(); 
								out.println(" <td><a href=" + lienFacture + " target='_blank'><img src='img/logoadobe.png'>" + nomFacture + "</a></td>");%>
							</tr>
				<% } 
				out.println(" </table> ");
				} else { 
					out.println("pas de facture ");
				} %> 
			</body> 
		</html>
			<%}
		}%>
		
