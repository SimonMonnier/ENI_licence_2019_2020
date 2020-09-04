package fr.eni.pservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.pdal.FabriqueDAO;
import fr.eni.pdal.ProduitDAO;
import fr.eni.pmodel.Produit;

/**
 * Servlet implementation class ServletRechercheProduit
 */
@WebServlet("/ServletRechercheProduit")
public class ServletRechercheProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRechercheProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageCible;
		
		// r�cup�rer le crit�re
		String critere = request.getParameter("slug");
		// d�l�guer la cr�tion de l'objet � une autre servlet
		ProduitDAO catalogue = FabriqueDAO.getDAO();
		// recherche du produit dans le catalogue
		Produit produit = catalogue.getProduitParNom(critere);
		
		if (produit != null) 
		{
			//D�l�guer la partie pr�sentation � une autre servlet
			request.setAttribute("produit", produit);
			pageCible = "/jsp/VueProduit.jsp";
		}
		else
		{
			String message = "Erreur ! Le produit portant le nom : '" + critere + "' n'existe pas !";
			// d�l�gation de l'affichage de la page d'erreur de la page
			request.setAttribute("message", message);
			pageCible = "/jsp/VueErreur.jsp";
		}
		request.getRequestDispatcher(pageCible).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
