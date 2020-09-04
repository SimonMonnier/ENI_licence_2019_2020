<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ElectroWarehouse</title>
		<link rel="stylesheet" href="../css/style.css" type="text/css">
		<script src="../js/form.js" type="text/javascript"></script>
	</head>
	<body>
		<header id="header"><h1>ElectroWarehouse</h1></header>
		<%@ include file="/jsp/NavBar.jsp" %>
		<main>
			<section id="inscription">
				<div class="container-inscription">
					<div class="inscription">
  						<h1>Inscription :</h1>
  						<form>
  							<label for="nom">Nom : <span class="spanNom" id="spanNom">/!\ Erreur de saisie</span></label>
  							<input type="text" id="nom" name="nom" placeholder="Monnier">
  							
  							<label for="prenom">Prénom : <span class="spanPrenom" id="spanPrenom">/!\ Erreur de saisie</span></label>
  							<input type="text" id="prenom" name="prenom"  placeholder="Simon">
  							
  							<label for="email">Email : <span class="spanMail" id="spanMail">/!\ Email invalide</span></label>
  							<input type="email" id="email" name="email"  placeholder="simon.monnier2019@campus-eni.fr">
  							
  							<label for="tel">Tel : <span class="spanTel" id="spanTel">/!\ Tel invalide (ex: 0777670347)</span></label>
  							<input type="text" id="tel" name="tel" placeholder="0777670347" >
  							
  							<label for="date_naiss">Date de naissance : <span class="spanDate" id="spanDate">/!\ Requis</span></label>
  							<input type="date" id="date_naiss" name="date_naiss" placeholder="01/01/2002">
  							
  							<label for="adresse">Adresse : <span class="spanAdresse" id="spanAdresse">/!\ Erreur de saisie</span></label>
  							<textarea rows="2" id="adresse" name="adresse" placeholder="77 rue de paris 44300 Nantes"></textarea>
  							
  							<label for="mdp">Mot de passe : <span class="spanPassword" id="spanPassword">/!\ Obligatoire</span></label>
  							<input type="password" id="mdp" name="mdp" placeholder="Entrez votre mot de passe">
  							
  							<label for="conf_mdp">Confirmation : <span class="spanConfirmation" id="spanConfirmation">/!\ Erreur</span></label>
  							<input type="password" id="conf_mdp" name="conf_mdp" placeholder="Confirmez votre mot de passe">
  							
  							<span id="spanEnvoyer" class="submitFormDisable"><button type="submit" id="submitForm" class="submitFormDisable">Envoyer</button></span>
  							<span class="spanButton" id="spanButton">/!\ Veuillez remplir le formulaire</span>
  							
  						</form>
					</div>
				</div>
			</section>
		</main>
		<footer class="footer-blank">
			<section id="copyright">
				<div class="container-copyright">
					<div class="">
						<div class="">
							<p><a href="https://github.com/SimonMonnier" target=_blank>Made with love by Simon - Github</a></p>
							<p>Copyright &copy; 2020 All rights reserved</p>
						</div>
					</div>
				</div>
			</section>
		</footer>
	</body>
</html>