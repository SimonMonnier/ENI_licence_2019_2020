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
 * Servlet implementation class ServletAjoutProduit
 */
@WebServlet("/ServletAjoutProduit")

public class ServletAjoutProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjoutProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageCible;
		
		// déléguer la création de l'objet à une autre servlet
		ProduitDAO catalogue = FabriqueDAO.getDAO();

		String slug = catalogue.ajoutProduit(request, response);
		
		Produit produit = catalogue.getProduitParNom(slug);
		
		if (produit != null) 
		{
			//Déléguer la partie présentation à une autre servlet
			request.setAttribute("produit", produit);
			pageCible = "/jsp/VueAdmin.jsp";
		}
		else
		{
			String message = "Erreur ! Le catalogue est vide ou n'existe pas !";
			// délégation de l'affichage de la page d'erreur de la page
			request.setAttribute("message", message);
			pageCible = "/jsp/VueErreur.jsp";
		}
		request.getRequestDispatcher(pageCible).forward(request, response);
	}

}
