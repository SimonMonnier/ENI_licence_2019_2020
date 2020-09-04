package fr.eni.pdal;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.pmodel.Categorie;
import fr.eni.pmodel.Produit;

public class ProduitDAOImpEnMemoire implements ProduitDAO{
	/*** Attributs private***/
	private ArrayList<Produit>listeProduits = new ArrayList<Produit>();
	
	/*** Constructeurs***/
	public ProduitDAOImpEnMemoire ()
	{
		listeProduits.add(new Produit("ELITEBOOK_820_G1", Categorie.PC_portable, "HP", 2019, 599.00, 17, "/ElectroWarehouse/images/product01.png", "Intel Core i5-4200U 1.60GHz / 8Go RAM DDR3 / 320Go HDD / 12.5'"));
		listeProduits.add(new Produit("S413DA-EK068T", Categorie.PC_portable, "Asus", 2020, 777.00, 7, "/ElectroWarehouse/images/product03.png", "PC Ultra-Portable Asus 14' AMD Ryzen 5 8 Go RAM 512 Go SSD Noir"));
		listeProduits.add(new Produit("GALAXY_TAB_A", Categorie.Tablette, "Samsung", 2018, 225.00, 10, "/ElectroWarehouse/images/product04.png", "SAMSUNG GALAXY TAB A 10.1'' 32GO WIFI NOIR"));
		listeProduits.add(new Produit("QuietComfort_35_II", Categorie.Casque_sans_fil, "Bose", 2017, 55.00, 27, "/ElectroWarehouse/images/product05.png", "Casque sans fil Bose QuietComfort 35 II"));
	}
	
	/*** Methodes ***/
	public Produit getProduitParNom (String nom)
	{
		for (Produit p : listeProduits)
			if (p.getNom().equals(nom))
				return p;
		return null;
	}
	
	public ArrayList<Produit> getCatalogue ()
	{
		return listeProduits;
	}

	@Override
	public String ajoutProduit(HttpServletRequest request, HttpServletResponse response) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
