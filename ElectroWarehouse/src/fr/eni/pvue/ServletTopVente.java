package fr.eni.pvue;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.pdal.FabriqueDAO;
import fr.eni.pdal.ProduitDAO;
import fr.eni.pmodel.Produit;
/**
 * Servlet implementation class ServletTopVente
 */
@WebServlet("/ServletTopVente")
public class ServletTopVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTopVente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageCible;
		
		// déléguer la création de l'objet à une autre servlet
		ProduitDAO catalogue = FabriqueDAO.getDAO();
		ArrayList<Produit> produits = catalogue.getCatalogue();
		
		if (produits != null) 
		{
			//Déléguer la partie présentation à une autre servlet
			request.setAttribute("catalogue", produits);
			pageCible = "/jsp/VueTopVentes.jsp";
		}
		else
		{
			String message = "Erreur ! Pas de Top Ventes ou n'existe pas !";
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