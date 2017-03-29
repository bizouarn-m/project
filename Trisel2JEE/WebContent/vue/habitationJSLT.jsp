<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=\ "utf-8\" />
<title>Affichage factures</title>
</head>

<body>
	<p>
		<a href='./MenuGeneral'>  Retour Menu General</a>
	<h1>
		<c:out value="${sessionScope.usag.nom}" />
		<c:out value="${sessionScope.usag.prenom}" />
	</h1>
	<!--parcours des habitations-->
	<c:choose>
		<c:when test="${sessionScope.usag.lesHabitations.size() == 0}">
			Aucune habitation connue
		</c:when>
		<c:otherwise>
			<c:forEach var="habitation" items="${sessionScope.usag.lesHabitations}">
				<p>pour le logement situé à</p>
				<c:out value="${habitation.adrRueHab}" />
				<br />
				<c:out value ="${habitation.adrVilleHab}" />
				<br />
				<c:choose>
					<c:when test="${habitation.lesFactures.size() == 0}">
						<p>pas de facture<p>
					</c:when>
					<c:otherwise>
						<p>
							Vous disposez de<c:out value="${habitation.lesFactures.size()}" /> facture(s)
						<table border="1">
							<tr>
								<th>liste des factures</th>
							</tr>
							<c:forEach var="facture" items="${habitation.lesFactures}">
								<tr>
									<td><a href=pdf /<c:out value="${facture.nomFacture}"/>target='_blank'> <img src='img/logoadobe.png'> <c:out value="${facture.nomFacture}" />
									</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>

