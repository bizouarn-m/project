<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- entete page html-->
<!DOCTYPE html>
<html>
<head>
<meta charset=\ "utf-8\" />
<title>Formulaire authentification</title>
</head>
<!-- lien vers le fichier javascript de controles à la saisie-->
<script type='text/javascript' src='js/controle.js'></script>
<body>
	<H1>
		<img src='img/Trisel.jpg' width='150' height='150'> Accès au
		portail de la Communauté des Communes
	</H1>
	<p>Veuillez vous authentifier avec le code usager et le mot de
		passe que vous avez reçu par courrier</p>
		
	<!-- on récupère le message éventuel si il ne s'agit pas de l'appel initial au formulaire-->
		<!-- on affiche le message -->
		<%String message = request.getParameter("message");
		if (message != null) {
			out.println("<font color=Red>" + message + "</br></font>");
		}%>
	
	<form name='authentification' method='post'
		onSubmit='return verifForm(this)' action='./Authentification'>
		<table>
			<tr>
				<td>code usager</td>
				<td><input type=text name=user></td>
			</tr>
			<tr>
				<td>mot de passe</td>
				<td><input type=text name=mdp></td>
			</tr>
		</table>
		<input type=submit name=valider value=valider> <input
			type=reset name=annuler value=annuler>
	</form>
</body>
</html>