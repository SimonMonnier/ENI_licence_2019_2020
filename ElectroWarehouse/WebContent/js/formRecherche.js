/**
 * 
 */
var etatNom = false;
var etatMarque = false;
var etatAnnee = false;
var etatPrix = false;
var etatQuantite = false;
var etatDescriptif = false;
var etatImage = false;

window.onload = function (){
	document.getElementById("nom").addEventListener("blur", controlNom, false);
}

function controlNom() {
	
	var nom = document.getElementById('nom').value;
	nom = nom.replace(/<(?:.|\n)*?>/gm, '');
	
	if ( nom.length < 2)
	{
		document.getElementById('spanNom').className = "spanNomView";
		etatNom = false;
		document.getElementById("submitForm").disabled = true;
	}
	else
	{
		document.getElementById('spanNom').className = "spanNom";
		etatNom = true;
	}
}
