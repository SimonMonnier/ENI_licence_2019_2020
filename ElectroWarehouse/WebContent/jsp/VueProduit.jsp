<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="fr.eni.pmodel.Produit" %>


<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ElectroWarehouse</title>
		<link rel="stylesheet" href="/ElectroWarehouse/css/style.css" type="text/css">
		<script src="/ElectroWarehouse/js/scroll.js" type="text/javascript"></script>
		<script src="/ElectroWarehouse/js/slide.js" type="text/javascript"></script>
	</head>
	<body>
		<%  
			//récupère l'objet à afficher
			Produit produit = (Produit)request.getAttribute("produit");
		%>
		<header id="header"><h1>ElectroWarehouse</h1></header>
		<%@ include file="/jsp/NavBar.jsp" %>
		<main>
			<section id="produits">
				<div class="container-produits">
					<div class="produit">
						<table>
							<caption><%= produit.getNom() %></caption>
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
									<td><span class="spantxt"><%= produit.getNom() %></span></td>
									<td><%= produit.getCategorie() %></td>
									<td><%= produit.getMarque() %></td>
									<td><%= produit.getAnnee() %></td>
									<td><span class="spantxt"><%= produit.getPrix() + "$" %></span></td>
									<td><span class="spantxt"><%= produit.getQuantite() %></span></td>
								</tr>
							</tbody>
							<tfoot></tfoot>
					</table>
					<img class="make-up" src="./<%= produit.getUrlImage() %>" alt="PC"></img>
					<h4 style="margin-top: 10px; margin-bottom: 30px"><%= produit.getDescriptif() %>"</h4>
				</div>
			</div>
		</section>
		</main>
		<%@ include file="/jsp/Footer.jsp" %>
	</body>
</html>