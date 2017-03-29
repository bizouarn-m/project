<%@ page language="java" contentType="text/html"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultation factures ordures ménagères</title>
</head>
<body>
<form action="./MenuGeneral" method="post">
<p><a href='./Authentification'> Déconnexion</a>
<Table border=1>

<tr>
<td>Liste des factures en serv-jsp-scriptjava </td>
<td><input type="submit" name="action" value="ServScript"/></td>
</tr>
<tr>
<td>Liste des factures en serv-jsp-jslt </td>
<td><input type="submit" name="action" value="ServJslt"/></td>
</tr>
<tr>
<td>Liste des factures avec liste déroulante </td>
<td><input type="submit" name="action" value="ServList"/></td>
</tr>
</Table>
</form>
</body>
</html>