package fr.eni.pdal;

//Design pattern factory
//Est responsable de la création des objet, il centralise la création des objets

public class FabriqueDAO {

	//Définition d'une méthode qui créé l'objet de type DAO
	public static ProduitDAO getDAO () 
	{
		//return new ProduitDAOImpEnMemoire ();
		return new ProduitDAOImpEnBd ();
	}
}
