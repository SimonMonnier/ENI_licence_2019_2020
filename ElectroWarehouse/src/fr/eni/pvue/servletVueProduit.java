package fr.eni.pvue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.pmodel.Produit;

/**
 * Servlet implementation class servletVueProduit
 */
@WebServlet("/servletVueProduit")
public class servletVueProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletVueProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//récupère l'objet à afficher
				Produit produit = (Produit)request.getAttribute("produit");
				
				//indique le type de la réponse
				response.setContentType("text/html");
				
				// Ouverture du flux avec le client
				PrintWriter out = response.getWriter();

				// génération de la page html
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset=\"ISO-8859-1\">");
				out.println("<title>ElectroWarehouse</title>");
				out.println("<link rel=\"stylesheet\" href=\"/ElectroWarehouse/css/style.css\" type=\"text/css\">");
				out.println("<script src=\"/ElectroWarehouse/js/scroll.js\" type=\"text/javascript\"></script>");
				//out.println("<script src=\"/ElectroWarehouse/js/slide.js\" type=\"text/javascript\"></script>");
				out.println("</head>");
				out.println("<body>");
				out.println("<header id=\"header\"><h1>ElectroWarehouse</h1></header>");
				out.println("<nav id=\"nav\">");
				out.println("<div class=\"container-nav\">");
				out.println("<ul>");
				out.println("<li>");
				out.println("<a class=\"logo\" href=\"/ElectroWarehouse/index.html\"><img src=\"/ElectroWarehouse/images/logo.png\" alt=\"logo\"></img></a>");
				out.println("<a class=\"logo_hover\" href=\"/ElectroWarehouse/index.html\"><img src=\"/ElectroWarehouse/images/logo_hover.png\" alt=\"logo\"></img></a>");
				out.println("</li>");
				out.println("<li>");
				out.println("<a href=\"/ElectroWarehouse/html/photos.html\">Top ventes</a>");
				out.println("</li>");
				out.println("<li>");
				out.println("<a href=\"/ElectroWarehouse/html/produits.html\">Nos produits</a>");
				out.println("</li>");
				out.println("<li>");
				out.println("<a href=\"/ElectroWarehouse/html/contact.html\">Nous contater</a>");
				out.println("</li>");
				out.println("<li>");
				out.println("<a href=\"/ElectroWarehouse/html/favoris.html\">Nos partenaires</a>");
				out.println("</li>");
				out.println("<li>");
				out.println("<a href=\"/ElectroWarehouse/html/information.html\">Notre charte</a>");
				out.println("</li>");
				out.println("<li>");
				out.println("<a href=\"/ElectroWarehouse/html/inscription.html\">Inscription</a>");
				out.println("</li>");
				out.println("<li>");
				out.println("<a href=\"/ElectroWarehouse/html/videos.html\">Vidéos</a>");
				out.println("</li>");
				out.println("</ul>");
				out.println("</div>");
				out.println("</nav>");
				out.println("<main>");
				out.println("<section id=\"produits\">");
				out.println("<div class=\"container-produits\">");
				out.println("<div class=\"produit\">");
				out.println("<table>");
				out.println("<caption>" + produit.getNom() + "</caption>");
				out.println("<thead>");
				out.println("<tr>");
				//out.println("<th></th>");
				out.println("<th><span class=\"spantxt\">Nom</span></th>");
				out.println("<th><span class=\"spantxt\">Type</span></th>");
				out.println("<th><span class=\"spantxt\">Marque</span></th>");
				out.println("<th><span class=\"spantxt\">Année</span></th>");
				out.println("<th><span class=\"spantxt\">Prix</span></th>");
				out.println("<th><span class=\"spantxt\">Stock</span></th>");
				out.println("</tr>");
				out.println("</thead>");
				out.println("<tbody>");
				out.println("<tr class=\"tr_pair\">");
				//out.println("<td><img src=\"" + produit.getUrlImage() + "\" alt=\"PC\"></td>");
				out.println("<td><span class=\"spantxt\">" + produit.getNom() + "</span></td>");
				out.println("<td>" + produit.getCategorie() + "</td>");
				out.println("<td>" + produit.getMarque() + "</td>");
				out.println("<td>" + produit.getAnnee() + "</td>");
				out.println("<td><span class=\"spantxt\">" + produit.getPrix() + "$</span></td>");
				out.println("<td><span class=\"spantxt\">" + produit.getQuantite() + "</span></td>");
				out.println("</tr>");
				out.println("</tbody>");
				out.println("<tfoot></tfoot>");
				out.println("</table>");
				out.println("<img class=\"make-up\" src=\"" + produit.getUrlImage() + "\" alt=\"PC\"></a>");
				out.println("<h4 style=\"margin-top: 10px; margin-bottom: 30px\">" + produit.getDescriptif() + "</h4>");
				out.println("</div>");
				out.println("</div>");
				out.println("</section>");
				out.println("</main>");
				out.println("<footer>");
				out.println("<section id=\"copyright\">");
				out.println("<div class=\"container-copyright\">");
				out.println("<div>");
				out.println("<div>");
				out.println("<p><a href=\"https://github.com/SimonMonnier\" target=_blank>Made with love by Simon - Github</a></p>");
				out.println("<p>Copyright &copy; 2020 All rights reserved</p>");
				out.println("</div>");
				out.println("</div>");
				out.println("</div>");
				out.println("</section>");
				out.println("</footer>");
				out.println("</body>");
				out.println("</html>");
				// fermeture du flux avec le client
				out.close(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
