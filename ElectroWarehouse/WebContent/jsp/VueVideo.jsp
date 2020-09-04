<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ElectroWarehouse</title>
		<link rel="stylesheet" href="../css/style.css" type="text/css">
		<script src="../js/slideVideo.js" type="text/javascript"></script>
	</head>
	<body>
		<header id="header"><h1>ElectroWarehouse</h1></header>
		<%@ include file="/jsp/NavBar.jsp" %>
		<main>
			<section id="produits">
				<div class="container-produits">
					<div class="navSlide"><button id="navSlideLeft" type="button">&#139;</button></div>
					<div class="produit" id="slide1">
						<h1 class="">Enceinte Bleutooth - Bose</h1>
						<video src="/ElectroWarehouse/videos/enceinte-bose-music-is-my-fuel.mp4"  width="800" height="600"  preload="auto" autoplay></video>
					</div>
  					<div class="produit" id="slide2">
  						<h1 class="">Alienware Area 51M - Dell</h1>
						<video src="/ElectroWarehouse/videos/alienware-area-51m-product-video.mp4"  width="800" height="600"  ></video>
					</div>
					<div class="produit" id="slide3">
						<h1 class="">Deep Learning Workstation - Bizon</h1>
						<video src="/ElectroWarehouse/videos/deep-learning-workstation.mp4"  width="800" height="600"  ></video>
					</div>
					<div class="produit" id="slide4">
						<h1 class="">Iphone 11 pro - Apple</h1>
						<video src="/ElectroWarehouse/videos/voici-liphone-11-pro-apple.mp4"  width="800" height="600"  ></video> 
					</div>
					<div class="produit" id="slide5">
						<h1 class="">Playstation 5 - Sony</h1>
						<video src="/ElectroWarehouse/videos/ps5-trailer-officiel-playstation-5.mp4"  width="800" height="600"  ></video>
					</div>
					<div class="produit" id="slide6">
						<h1 class="">TV Bravia - Sony</h1>
						<video src="/ElectroWarehouse/videos/tv-sony-bravia-decouvrez-vos-sens-spot-pub-2019-cobrafr.mp4"  width="800" height="600"  ></video>
					</div>
					<div class="produit" id="slide7">
						<h1 class="">Galaxy Fold - Samsung</h1>
						<video src="/ElectroWarehouse/videos/galaxy-fold-official-introduction.mp4" width="800" height="600"  ></video>
					</div>
					<div class="produit" id="slide8">
						<h1 class="">TV Qled 8K - Samsung</h1>
						<video src="/ElectroWarehouse/videos/samsung-uk-qled-8k.mp4"  width="800" height="600"  ></video>
					</div>
					<div class="produit" id="slide9">
						<h1 class="">Xbox Series X - Microsoft</h1>
						<video src="/ElectroWarehouse/videos/xbox-series-x-world-premiere-4k-trailer.mp4"  width="800" height="600"  ></video>
					</div>
					<div class="produit" id="slide10">
						<h1 class="">Portégé X20W - Toshiba</h1>
						<video src="/ElectroWarehouse/videos/Portégé_X20W_toshiba.mp4"  width="800" height="600"  ></video>
					</div>
					<div class="produit" id="slide11">
						<h1 class="">P40 Series - Huawei</h1>
						<video src="/ElectroWarehouse/videos/huawei-p40-series.mp4"  width="800" height="600"  ></video>
					</div>
					<div class="produit" id="slide12">
						<h1 class="">Alienware Aurora R9 - Dell</h1>
						<video src="/ElectroWarehouse/videos/community-first-look-alienware-aurora-r9.mp4"  width="800" height="600"  ></video>
					</div>
					<div class="produit" id="slide13">
						<h1 class="">Casque Quietcomfortl - Bose</h1>
						<video src="/ElectroWarehouse/videos/casque-bose-quietcomfort.mp4"  width="800" height="600"  ></video>
					</div>
					<div class="navSlide"><button id="navSlideRight" type="button">&#155;</button></div>
				</div>
			</section>
		</main>
		<%@ include file="/jsp/Footer.jsp" %>
	</body>
</html>