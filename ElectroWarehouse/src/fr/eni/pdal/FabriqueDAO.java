package fr.eni.pdal;

//Design pattern factory
//Est responsable de la cr�ation des objet, il centralise la cr�ation des objets

public class FabriqueDAO {

	//D�finition d'une m�thode qui cr�� l'objet de type DAO
	public static ProduitDAO getDAO () 
	{
		//return new ProduitDAOImpEnMemoire ();
		return new ProduitDAOImpEnBd ();
	}
}
