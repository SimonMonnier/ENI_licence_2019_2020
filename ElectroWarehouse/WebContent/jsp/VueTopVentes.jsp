<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="fr.eni.pmodel.Produit" import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ElectroWarehouse</title>
		<link rel="stylesheet" href="/ElectroWarehouse/css/style.css" type="text/css">
		<script src="/ElectroWarehouse/js/slide.js" type="text/javascript"></script>
	</head>
	<body>
		<%  
			//récupère l'objet à afficher
			@SuppressWarnings("unchecked")
			ArrayList<Produit> catalogue = (ArrayList<Produit>)request.getAttribute("catalogue");
		%>
		<header id="header"><h1>ElectroWarehouse</h1></header>
		<%@ include file="/jsp/NavBar.jsp" %>
		<main>
			<section id="produits">
				<div class="container-produits">
					<div class="navSlide"><button id="navSlideLeft" type="button">&#139;</button></div>
  					<% int i = 1; for ( Produit produit : catalogue ) { %>
	  					<div class="produit" id="slide<%= i %>">
							<h1 class=""><%= produit.getNom() %></h1>
							<p class=""><%= produit.getDescriptif() %></p>
							<a href="/ElectroWarehouse/ServletRechercheProduit?slug=<%= produit.getSlug() %>"><img class="make-up" src="./<%= produit.getUrlImage() %>" alt="<%= produit.getCategorie() %>"></a>
						</div>
					<% i += 1; } %>
					<div class="navSlide"><button id="navSlideRight" type="button">&#155;</button></div>
				</div>
			</section>
		</main>
		<%@ include file="/jsp/Footer.jsp" %>
	</body>
</html>