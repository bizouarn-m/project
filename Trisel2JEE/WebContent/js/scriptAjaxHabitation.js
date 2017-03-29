var requete;
function valider(valeur) {
	// appel à la servlet Ajax
	var url = "./HabitationAjax?valeur=" + valeur;

	if (window.XMLHttpRequest) {
		requete = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		requete = new ActiveXObject("Microsoft.XMLHTTP");
	}
	requete.open("GET", url, true);
	requete.onreadystatechange = majIHM;
	requete.send(null);
}

function majIHM() {

	if (requete.readyState == 4) {
		if (requete.status == 200) {

			// ramène la réponse ajax dans la div listeFacture
			document.getElementById("listeFacture").innerHTML=requete.responseText;
		} else
			alert("pb  dans ajax : "+ requete.status);
	}
}