/**
 * 
 */
var etatNom = false;
var etatPrenom = false;
var etatEmail = false;
var etatTel = false;
var etatDateNaiss = false;
var etatAdresse = false;
var etatMdp = false;
var etatConfMdp = false;

window.onload = function (){
	document.getElementById("nom").addEventListener("blur", controlNom, false);
	document.getElementById("prenom").addEventListener("blur", controlPrenom, false);
	document.getElementById("email").addEventListener("blur", controlEmail, false);
	document.getElementById("tel").addEventListener("blur", controlTel, false);
	document.getElementById("date_naiss").addEventListener("blur", controlDate, false);
	document.getElementById("adresse").addEventListener("blur", controlAdresse, false);
	document.getElementById("mdp").addEventListener("blur", controlMdp, false);
	document.getElementById("conf_mdp").addEventListener("blur", controlConfMdp, false);
	document.getElementById("spanEnvoyer").addEventListener("mouseover", controlSubmitForm, false);
	document.getElementById("submitForm").disabled = true;
}

function controlNom() {
	
	var pattern = /[a-zA-ZéèîïÉÈÎÏ][a-zéèêàçîï]+([-‘\s][a-zA-ZéèîïÉÈÎÏ][a-zéèêàçîï]+)?$/;
	var nom = document.getElementById('nom').value;
	if ( !pattern.test(nom) )
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

function controlPrenom() {
	
	var pattern = /[a-zA-ZéèîïÉÈÎÏ][a-zéèêàçîï]+([-‘\s][a-zA-ZéèîïÉÈÎÏ][a-zéèêàçîï]+)?$/;
	var prenom = document.getElementById('prenom').value;
	if ( !pattern.test(prenom) )
	{
		document.getElementById('spanPrenom').className = "spanPrenomView";
		etatPrenom = false;
		document.getElementById("submitForm").disabled = true;
	}
	else
	{
		document.getElementById('spanPrenom').className = "spanPrenom";
		etatPrenom = true;
	}
}

function controlEmail() {
	
	var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
	var email = document.getElementById('email').value;
	if ( !pattern.test(email) )
	{
		document.getElementById('spanMail').className = "spanMailView";
		etatEmail = false;
		document.getElementById("submitForm").disabled = true;
	}
	else
	{
		document.getElementById('spanMail').className = "spanMail";
		etatEmail = true;
	}
}

function controlTel() {
	
	var pattern = /[0][1-9][0-9]{8}$/;
	var tel = document.getElementById('tel').value;
	if ( !pattern.test(tel) )
	{
		document.getElementById('spanTel').className = "spanTelView";
		etatTel = false;
		document.getElementById("submitForm").disabled = true;
	}
	else
	{
		document.getElementById('spanTel').className = "spanTel";
		etatTel = true;
	}
}

function controlDate() {
	
	var date = document.getElementById('date_naiss').value;

	if ( !date)
	{
		document.getElementById('spanDate').className = "spanDateView";
		etatDateNaiss = false;
		document.getElementById("submitForm").disabled = true;
	}
	else
	{
		document.getElementById('spanDate').className = "spanDate";
		etatDateNaiss = true;
	}
}

function controlAdresse() {
	
	var adresse = document.getElementById('adresse').value;

	if ( !adresse || adresse.length < 10)
	{
		document.getElementById('spanAdresse').className = "spanAdresseView";
		etatAdresse = false;
		document.getElementById("submitForm").disabled = true;
	}
	else
	{
		document.getElementById('spanAdresse').className = "spanAdresse";
		etatAdresse = true;
	}
}

function controlMdp() {
	
	var mdp = document.getElementById('mdp').value;

	if ( !mdp || mdp.length < 4)
	{
		document.getElementById('spanPassword').className = "spanPasswordView";
		etatMdp = false;
		document.getElementById("submitForm").disabled = true;
	}
	else
	{
		document.getElementById('spanPassword').className = "spanPassword";
		etatMdp = true;
	}
}

function controlConfMdp() {
	
	var mdp = document.getElementById('conf_mdp').value;
	var confMdp = document.getElementById('mdp').value;
	
	if ( mdp != confMdp )
	{
		document.getElementById('spanConfirmation').className = "spanConfirmationView";
		document.getElementById('spanPassword').className = "spanPasswordView";
		etatConfMdp = false;
		document.getElementById("submitForm").disabled = true;
	}
	else
	{
		document.getElementById('spanConfirmation').className = "spanConfirmation";
		document.getElementById('spanPassword').className = "spanPassword";
		etatConfMdp = true;
	}
}

function controlSubmitForm() {
	
	if ( etatNom == true && etatPrenom == true 
			&& etatEmail == true && etatTel == true 
			&& etatDateNaiss == true && etatAdresse == true 
			&& etatMdp == true && etatConfMdp == true )
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