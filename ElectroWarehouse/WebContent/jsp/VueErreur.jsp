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
			String message = (String)request.getAttribute("message");
		%>
		<header id="header"><h1>ElectroWarehouse</h1></header>
		<%@ include file="/jsp/NavBar.jsp" %>
		<main>
			<section id="produits">
				<div class="container-produits">
					<div class="produit">
						<h1> <%= message %> </h1>
					</div>
				</div>
			</section>
		</main>
		<%@ include file="/jsp/FooterBlank.jsp" %>
	</body>
</html>