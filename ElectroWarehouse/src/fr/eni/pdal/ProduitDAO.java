package fr.eni.pdal;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.pmodel.Produit;

public interface ProduitDAO {
	Produit getProduitParNom (String nom);
	ArrayList<Produit> getCatalogue();
	String ajoutProduit(HttpServletRequest request, HttpServletResponse response);
}
