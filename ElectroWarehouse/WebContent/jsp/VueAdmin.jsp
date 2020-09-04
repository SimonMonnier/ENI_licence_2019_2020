<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="fr.eni.pmodel.Produit" import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ElectroWarehouse</title>
		<link rel="stylesheet" href="/ElectroWarehouse/css/style.css" type="text/css">
		<script src="/ElectroWarehouse/js/formAjoutProduit.js" type="text/javascript"></script>
	</head>
	<body>
		<%  
			//récupère l'objet à afficher
			Produit produit = (Produit)request.getAttribute("produit");
			//récupère l'objet à afficher
			@SuppressWarnings("unchecked")
			ArrayList<Produit> catalogue = (ArrayList<Produit>)request.getAttribute("catalogue");
		%>
		<header id="header"><h1>ElectroWarehouse</h1></header>
		<%@ include file="/jsp/NavBar.jsp" %>
		<main>
			<section id="inscription">
				<div class="container-inscription">
					<div class="admin">
  						<h1>Ajout produit</h1>
  						<form method="POST" enctype="multipart/form-data" action="/ElectroWarehouse/ServletAjoutProduit" >
  							<label for="nom">Nom du produit : <span class="spanNom" id="spanNom">/!\ Requis</span></label>
  							<input type="text" id="nom" name="nom" placeholder="ELITEBOOK 820 G1">
  							
  							<label for="categorie">Catégorie : <span class="spanCategorie" id="spanCategorie">/!\ Requis</span></label>
  							<div class="adminCategorie">
								<label class="categorie1" for="categorie1">Pc portable</label>
	  							<input type="radio" id="categorie1" name="categorie"  value="PC_portable">
	  						</div>
	  						<div class="adminCategorie">
	  							<label class="categorie2" for="categorie2">Tablette</label>
	  							<input type="radio" id="categorie2" name="categorie"  value="Tablette">
	  						</div>
	  						<div class="adminCategorie">
	  							<label class="categorie3" for="categorie3">Casque sans fil</label>
	  							<input type="radio" id="categorie3" name="categorie"  value="Casque_sans_fil">
	  						</div>
	  						<div class="adminCategorie">
	  							<label class="categorie4" for="categorie4">Aucune catégorie</label>
	  							<input type="radio" id="categorie4" name="categorie"  value="Aucune" checked>
  							</div>
  							<br>
  							<label for="marque">Marque : <span class="spanMarque" id="spanMarque">/!\ Erreur de saisie</span></label>
  							<input list="marques" name="marque" id="marque" placeholder="Sony">
							<datalist id="marques">
							  <option value="Sony">
							  <option value="HP">
							  <option value="Bose">
							  <option value="Samsung">
							  <option value="Apple">
							</datalist>
							
  							<label for="annee">Année : <span class="spanAnnee" id="spanAnnee">/!\ Erreur de saisie</span></label>
  							<input type="number" id="annee" name="annee" value="2019" step="1" min="1990" max="2050" >
  							
  							<label for="prix">Prix : <span class="spanPrix" id="spanPrix">/!\ Erreur de saisie</span></label>
  							<input type="number" id="prix" name="prix" placeholder="777" min="1" max="100000" >
  							
  							<label for="quantite">Quantité : <span class="spanQuantite" id="spanQuantite">/!\ Erreur de saisie</span></label>
  							<input type="number" id="quantite" name="quantite" value="1" step="1" min="0" max="100000">
  							
  							<label for="descriptif">Descriptif : <span class="spanDescriptif" id="spanDescriptif">/!\ Erreur de saisie</span></label>
  							<textarea rows="2" id="descriptif" name="descriptif" placeholder="Entrez un bref descriptif du produit ..."></textarea>
  							
  							<label for="image">Image : <span class="spanImage" id="spanImage">/!\ Format : "png"</span></label>
  							<input type="file" id="image" name="image" >
  							
  							
  							<span id="spanEnvoyer" class="submitFormDisable"><button type="submit" id="submitForm" class="submitFormDisable">Envoyer</button></span>
  							<span class="spanButton" id="spanButton">/!\ Veuillez remplir le formulaire</span>
  							
  						</form>
					</div>
				</div>
				<div class="container-produits" <% if (produit == null) { %> style="display: none;" <% } %>>
					<div class="produit">
						<table>
							<caption> Résultat</caption>
							<thead>
								<tr>
									<th><span class="spantxt">Nom</span></th>
									<th><span class="spantxt">Type</span></th>
									<th><span class="spantxt">Marque</span></th>
									<th><span class="spantxt">Année</span></th>
									<th><span class="spantxt">Prix</span></th>
									<th><span class="spantxt">Stock</span></th>
								</tr>
							</thead>
							<tbody>
								<tr class="tr_pair">
									<td><span class="spantxt"><% if (produit != null) { %> <%= produit.getNom() %> <% } %></span></td>
									<td><% if (produit != null) { %> <%= produit.getCategorie() %> <% } %></td>
									<td><% if (produit != null) { %> <%= produit.getMarque() %> <% } %></td>
									<td><% if (produit != null) { %> <%= produit.getAnnee() %> <% } %></td>
									<td><span class="spantxt"><% if (produit != null) { %> <%= produit.getPrix() %> <% } %></span></td>
			 						<td><span class="spantxt"><% if (produit != null) { %> <%= produit.getQuantite() %> <% } %></span></td>
								</tr>
							</tbody>
							<tfoot></tfoot>
						</table>
						<h4 style="margin-top: 10px; margin-bottom: 30px"><% if (produit != null) { %> <a href="/ElectroWarehouse/ServletRechercheProduit?slug=<%= produit.getSlug() %>"> Le Produit a été ajouté ! </a> <% } %></h4>
					</div>
				</div>
			</section>
			<section id="inscription">
				<div class="container-inscription">
					<div class="admin">
  						<h1>Recherche produit</h1>
  						<form method="POST" enctype="multipart/form-data" action="/ElectroWarehouse/ServletRecherche" >
  							<label for="nomR">Nom du produit : <span class="spanNom" id="spanNom">/!\ Requis</span></label>
  							<input type="text" id="nomR" name="nomR" placeholder="ELITEBOOK">
  							
  							<span id="spanEnvoyer" class="submitFormAllowed"><button type="submit" id="submitForm" class="submitFormAllowed">Rechercher</button></span>
  							
  						</form>
					</div>
				</div>
				
				
				
				<div class="container-produits" <% if (catalogue == null) { %> style="display: none;" <% } %>>
					<div class="produit">
						<table>
							<caption>Résultat</caption>
							<thead>
								<tr>
									<th><span class="spantxt">Nom</span></th>
									<th><span class="spantxt">Type</span></th>
									<th><span class="spantxt">Marque</span></th>
									<th><span class="spantxt">Année</span></th>
									<th><span class="spantxt">Prix</span></th>
									<th><span class="spantxt">Stock</span></th>
								</tr>
							</thead>
							<tbody>
								<% if (catalogue != null) { %><% int j = 2; for ( Produit p : catalogue ) { %>
									 <%  if ( j % 2 == 0) { j += 1; %>
											<tr class="tr_pair">
												<td><a href="/ElectroWarehouse/ServletRechercheProduit?slug=<%= p.getSlug() %>"><img src="./<%= p.getUrlImage() %>" alt="PC"></a></td>
												<td><span class="spantxt"><%= p.getNom() %></span></td>
												<td><%= p.getCategorie() %></td>
												<td><%= p.getMarque() %></td>
												<td><%= produit.getAnnee() %></td>
												<td><span class="spantxt"><%= p.getPrix() + "$" %></span></td>
												<td><span class="spantxt"><%= p.getQuantite() %></span></td>
											</tr>
									<% } else { j += 1; %>
										<tr class="tr_impair">
											<td><a href="/ElectroWarehouse/ServletRechercheProduit?slug=<%= p.getSlug() %>"><img src="./<%= p.getUrlImage() %>" alt="PC"></a></td>
											<td><span class="spantxt"><%= produit.getNom() %></span></td>
											<td><%= p.getCategorie() %></td>
											<td><%= p.getMarque() %></td>
											<td><%= p.getAnnee() %></td>
											<td><span class="spantxt"><%= p.getPrix() + "$" %></span></td>
											<td><span class="spantxt"><%= p.getQuantite() %></span></td>
										</tr>
									<% } }%><% } %>
							</tbody>
							<tfoot></tfoot>
						</table>
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