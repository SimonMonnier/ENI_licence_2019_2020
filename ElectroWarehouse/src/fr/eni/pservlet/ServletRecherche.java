package fr.eni.pservlet;

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
 * Servlet implementation class ServletRecherche
 */
@WebServlet("/ServletRecherche")
public class ServletRecherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRecherche() {
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
		String pageCible = null;;
		
		// déléguer la création de l'objet à une autre servlet
		ProduitDAO catalogue = FabriqueDAO.getDAO();

		ArrayList<Produit> produits = catalogue.getCatalogue();
		ArrayList<Produit> search = new ArrayList<Produit>();
		int cpt = 0;
		String strBd ;
		
		for ( Produit produit : produits )
		{
			strBd = null;

			String strProduit = produit.getNom();
			
			if (request.getAttribute("nomR") != null)
			{	
				strBd = request.getAttribute("nomR").toString();
			
				String[] arrOfStrProduit = strProduit.toLowerCase().split(" ");
				String[] arrOfStrBd = strBd.toLowerCase().split(" ");
				
				for (String strTmp1: arrOfStrBd)
				{
					for (String strTmp2: arrOfStrProduit)
					{
						if(strTmp1.equals(strTmp2) && cpt == 0)
						{
							search.add(produit);
							cpt += 1;
						}
					}
				}
			}
//			if (request.getAttribute("categorie") != null)
//			{
//				if ( produit.getCategorie().toString().equals(request.getAttribute("categorie")) && cpt == 0)
//				{
//					search.add(produit);
//					cpt += 1;
//				}
//			}
//			if (request.getAttribute("annee") != null)
//			{
//				if ( request.getAttribute("annee").equals(produit.getAnnee()) && cpt == 0)
//				{
//					search.add(produit);
//				}
//			}
			cpt = 0;
		}
		//Déléguer la partie présentation à une autre servlet
		request.setAttribute("catalogue", search);
		pageCible = "/jsp/VueAdmin.jsp";

		request.getRequestDispatcher(pageCible).forward(request, response);
	}
}
