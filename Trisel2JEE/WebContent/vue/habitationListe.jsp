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
		<script type="text/javascript" src="./js/scriptAjaxHabitation.js"></script>
		<%Usager usag = (Usager) request.getSession().getAttribute("usag");
	 List <Habitation> listeHabitation = usag.getLesHabitations();%>
	</head>

	<body>
	
	
		<p><a href='./MenuGeneral'> Retour Menu General</a> 
		<!--  // affichage nom et prenom de l'usager -->
		 <% out.println("<h1>");
		 out.println(usag.getNom() + " " + usag.getPrenom());
		out.println("</h1>");%>
		
		
		<% if (listeHabitation.size() != 0) {%>
		Liste des habitations consultables :
			<select name="choixHabitation"  onChange= "valider(this.value);" size="1" >
	 		<% for (Habitation h : listeHabitation) {
	 			out.println("<option value ='"+h.getIdHabitation()+"'>"+h.getAdrVilleHab()+"-"+h.getAdrRueHab()+"</option>");	 			
	 		}%>
 			</select>
 		  		
		<%}
		else{
			out.println("Aucune habitation connue ");
		}
 		%>		
		
				<div id="listeFacture"></div>
			</body> 
		</html>