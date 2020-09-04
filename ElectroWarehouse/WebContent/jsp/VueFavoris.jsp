<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ElectroWarehouse</title>
		<link rel="stylesheet" href="../css/style.css" type="text/css">
		<script src="../js/fonctions.js" type="text/javascript"></script>
	</head>
	<body>
		<header id="header"><h1>ElectroWarehouse</h1></header>
		<%@ include file="/jsp/NavBar.jsp" %>
		<main>
			<section id="favoris">
				<div class="container-favoris">
					<div class="favoris">
  						<h1>Nos partenaires :</h1>
						<ul> 
							<li>
								<a href="https://www.electrodepot.fr/" target=_blank> Electrod&eacute;pot</a>
							</li>
							<li>
								<a href="https://www.darty.com/" target=_blank> Darty</a>
							</li>
						</ul>
					</div>
				</div>
			</section>
		</main>
		<%@ include file="/jsp/FooterBlank.jsp" %>
	</body>
</html>