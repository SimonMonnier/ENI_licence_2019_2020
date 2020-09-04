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
		
		// récupérer le critère
		String critere = request.getParameter("slug");
		// déléguer la crétion de l'objet à une autre servlet
		ProduitDAO catalogue = FabriqueDAO.getDAO();
		// recherche du produit dans le catalogue
		Produit produit = catalogue.getProduitParNom(critere);
		
		if (produit != null) 
		{
			//Déléguer la partie présentation à une autre servlet
			request.setAttribute("produit", produit);
			pageCible = "/jsp/VueProduit.jsp";
		}
		else
		{
			String message = "Erreur ! Le produit portant le nom : '" + critere + "' n'existe pas !";
			// délégation de l'affichage de la page d'erreur de la page
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
