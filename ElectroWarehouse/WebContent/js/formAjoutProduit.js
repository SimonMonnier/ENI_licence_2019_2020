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
	document.getElementById("marque").addEventListener("blur", controlMarque, false);
	document.getElementById("annee").addEventListener("blur", controlAnnee, false);
	document.getElementById("prix").addEventListener("blur", controlPrix, false);
	document.getElementById("quantite").addEventListener("blur", controlQuantite, false);
	document.getElementById("descriptif").addEventListener("blur", controlDescriptif, false);
	document.getElementById("image").addEventListener("change", controlImage, false);
	document.getElementById("spanEnvoyer").addEventListener("mouseover", controlSubmitForm, false);
	document.getElementById("submitForm").disabled = true;
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

function controlMarque() {
	
	var marque = document.getElementById('marque').value;
	marque = marque.replace(/<(?:.|\n)*?>/gm, '');
	
	if ( marque == "" || marque.length < 2)
	{
		document.getElementById('spanMarque').className = "spanMarqueView";
		etatMarque = false;
		document.getElementById("submitForm").disabled = true;
	}
	else
	{
		document.getElementById('spanMarque').className = "spanMarque";
		etatMarque = true;
	}
}


function controlAnnee() {
	
	var annee = document.getElementById('annee').value;

	if ( annee < 1976 || annee > 2050)
	{
		document.getElementById('spanAnnee').className = "spanAnneeView";
		etatAnnee = false;
		document.getElementById("submitForm").disabled = true;
	}
	else
	{
		document.getElementById('spanAnnee').className = "spanAnnee";
		etatAnnee = true;
	}
	
}

function controlPrix() {
	
	var prix = document.getElementById('prix').value;

	if ( prix < 1 || prix > 100000)
	{
		document.getElementById('spanPrix').className = "spanPrixView";
		etatPrix = false;
		document.getElementById("submitForm").disabled = true;
	}
	else
	{
		document.getElementById('spanPrix').className = "spanPrix";
		etatPrix = true;
	}
}

function controlQuantite() {
	
	var quantite = document.getElementById('quantite').value;

	if ( quantite < 1 || quantite > 100000)
	{
		document.getElementById('spanQuantite').className = "spanQuantiteView";
		etatQuantite = false;
		document.getElementById("submitForm").disabled = true;
	}
	else
	{
		document.getElementById('spanQuantite').className = "spanQuantite";
		etatQuantite = true;
	}
}

function controlDescriptif() {
	
	var descriptif = document.getElementById('descriptif').value;
	descriptif = descriptif.replace(/<(?:.|\n)*?>/gm, '');
	
	if ( descriptif.length < 3 || descriptif.length > 510)
	{
		document.getElementById('spanDescriptif').className = "spanDescriptifView";
		etatDescriptif = false;
		document.getElementById("submitForm").disabled = true;
	}
	else
	{
		document.getElementById('spanDescriptif').className = "spanDescriptif";
		etatDescriptif = true;
	}
}

function controlImage() {
	
	var extensions = /(\.png)$/i;
	var image = document.getElementById('image').value;
	var filename = image.split(".").pop();
		
	if ( filename != "png" || filename == null)
	{
		document.getElementById('spanImage').className = "spanImageView";
		etatImage = false;
		document.getElementById("submitForm").disabled = true;
	}
	else
	{
		document.getElementById('spanImage').className = "spanImage";
		etatImage = true;
	}
}

function controlSubmitForm() {
	
	if ( etatNom == true && etatMarque == true 
			&& etatAnnee == true && etatPrix == true && etatQuantite == true 
			&& etatDescriptif == true && etatImage == true )
	{
		document.getElementById("submitForm").disabled = false;
		document.getElementById('submitForm').className = "submitFormAllowed";
		document.getElementById('spanEnvoyer').className = "submitFormAllowed";
		document.getElementById('spanButton').className = "spanButton";
	}
	else
	{
		document.getElementById("submitForm").disabled = true;
		document.getElementById('submitForm').className = "submitFormDisable";
		document.getElementById('spanEnvoyer').className = "submitFormDisable";
		document.getElementById('spanButton').className = "spanButtonView";
	}
}