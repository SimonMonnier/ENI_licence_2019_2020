package fr.eni.pdal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fr.eni.pmodel.Categorie;
import fr.eni.pmodel.Produit;

public class ProduitDAOImpEnBd implements ProduitDAO {

	/*** Attributs private***/
	private ArrayList<Produit>listeProduits = new ArrayList<Produit>();
	
	
	//Accès base de donnée
	
	
	/*** Methodes ***/
	public Produit getProduitParNom (String slug)
	{
		UtilBd utilBd = new UtilBd();
		Connection connexion = utilBd.ouvrirConnexion();
		String requete = "SELECT * FROM tb_produits";
		
		try
		{
			Statement stmt = connexion.createStatement();
			ResultSet rs = stmt.executeQuery( requete );
			
			while ( rs.next() )
			{
				if ( rs.getString("slug").equals(slug) )
				{
					Produit produit = new Produit();
					
					produit.setNom(rs.getString("nom"));
					int categorie = rs.getInt("categorie");
					switch (categorie)
					{
						case 0 : produit.setCategorie( Categorie.PC_portable );
								break;
						case 1 : produit.setCategorie( Categorie.Tablette );
								break;
						case 2 : produit.setCategorie( Categorie.Casque_sans_fil );
								break;
						default : produit.setCategorie( Categorie.Aucune );
					}
					produit.setMarque(rs.getString("marque"));
					produit.setAnnee(rs.getInt("annee"));
					produit.setPrix(rs.getDouble("prix"));
					produit.setQuantite(rs.getInt("quantite"));
					produit.setUrlImage(rs.getString("urlImage"));
					produit.setDescriptif(rs.getString("descriptif"));
					produit.setSlug
					(
							produit.getNom(),
							produit.getCategorie(),
							produit.getMarque(), 
							produit.getAnnee(), 
							produit.getQuantite()
					);
					
					utilBd.fermerConnexion(connexion);
					
					return produit;
				}
			}
			utilBd.fermerConnexion(connexion);
		}
		catch (Exception e)
		{
			System.out.println("Erreur requete" + e.getMessage() );
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Produit> getCatalogue ()
	{
		UtilBd utilBd = new UtilBd();
		Connection connexion = utilBd.ouvrirConnexion();
		
		try
		{
			String requete = "SELECT * FROM tb_produits";
			Statement stmt = connexion.createStatement();
			ResultSet rs = stmt.executeQuery( requete );
			
			while ( rs.next() )
			{
				Produit produit = new Produit();
				
				produit.setNom(rs.getString("nom"));
				int categorie = rs.getInt("categorie");
				switch (categorie)
				{
					case 0 : produit.setCategorie( Categorie.PC_portable );
							break;
					case 1 : produit.setCategorie( Categorie.Tablette );
							break;
					case 2 : produit.setCategorie( Categorie.Casque_sans_fil );
							break;
					default : produit.setCategorie( Categorie.Aucune );
				}
				produit.setMarque(rs.getString("marque"));
				produit.setAnnee(rs.getInt("annee"));
				produit.setPrix(rs.getDouble("prix"));
				produit.setQuantite(rs.getInt("quantite"));
				produit.setUrlImage(rs.getString("urlImage"));
				produit.setDescriptif(rs.getString("descriptif"));
				produit.setSlug
				(

						produit.getNom(),
						produit.getCategorie(),
						produit.getMarque(), 
						produit.getAnnee(), 
						produit.getQuantite()
				);
				
				listeProduits.add(produit);
			}
			utilBd.fermerConnexion(connexion);
			return listeProduits;
		}
		catch (Exception e)
		{
			System.out.println("Erreur requete" + e.getMessage() );
			e.printStackTrace();
		}
		return null;
	}
	
	public String ajoutProduit (HttpServletRequest request, HttpServletResponse response)
	{
		UtilBd utilBd = new UtilBd();
		String slug = null;
		Connection connexion = utilBd.ouvrirConnexion();
		try
		{
			Statement stmt = connexion.createStatement();

			String nom = (String) request.getParameter("nom");
			String categorieStr = (String) request.getParameter("categorie");
			
			int categorieInt;

			if (categorieStr.equals("PC_portable"))
				categorieInt = 0;
			else if (categorieStr.equals("Tablette"))
				categorieInt = 1;
			else if (categorieStr.equals("Casque_sans_fil"))
				categorieInt = 2;
			else
				categorieInt = 3;
			
			String marque = request.getParameter("marque");
			String annee =  request.getParameter("annee");
			String prix = request.getParameter("prix");
			String quantite = request.getParameter("quantite");
			String descriptif = request.getParameter("descriptif");
			slug = (nom + categorieStr + marque + annee + quantite).replaceAll("\\s+","");
			String urlImage = "/images/" + slug + ".png";
			String requete =  "INSERT INTO tb_produits (`nom`, `categorie`, `marque`, `annee`, `prix`, `quantite`, `urlImage`, `descriptif`, `slug`) VALUES ('" + nom + "' , '" + categorieInt + "' , '"+ marque +"' , '"
					+ annee + "' , '" + prix + "' , '" + quantite + "' , '" + urlImage + "' , '" 
					+ descriptif + "' , '" + slug +"')" ;
			
			stmt.executeUpdate( requete );
			
			utilBd.fermerConnexion(connexion);
			
			Part filePart = request.getPart("image");
			
		    InputStream fileInputStream = filePart.getInputStream();
		    
		    File fileToSave = new File(slug + ".png");
		    
		    
		    byte[] buffer = new byte[fileInputStream.available()];
		    fileInputStream.read(buffer);
			OutputStream outStream = new FileOutputStream(fileToSave);
		    outStream.write(buffer);
		    outStream.close();

		    Path fileToMovePath = fileToSave.toPath();

			@SuppressWarnings("deprecation")
			Path targetPath = Paths.get(request.getRealPath(urlImage));
		    System.out.println(targetPath);
		    Files.move(fileToMovePath, targetPath);
		    
		    
		}
		catch (Exception e)
		{
			System.out.println("Erreur requete" + e.getMessage() );
			e.printStackTrace();
		}
		return slug;
	}
}
