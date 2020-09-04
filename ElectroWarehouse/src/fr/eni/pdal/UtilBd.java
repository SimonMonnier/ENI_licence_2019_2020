package fr.eni.pdal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilBd {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url ="jdbc:mysql://localhost/db_electrowarehouse?serverTimezone=UTC";
	private String user = "root";
	private String password = "root";
	
	public Connection ouvrirConnexion()
	{
		Connection connexion = null;
		try
		{
			Class.forName(driver);
			connexion = DriverManager.getConnection( url, user, password );
		} catch(ClassNotFoundException e)
		{
			// classe du pilote introuvable
			System.out.println("classe du pilote introuvable " + driver);
			e.printStackTrace();
		} catch(SQLException e)
		{
			// accès à la base refusé
			System.out.println("accès à la base refusé");
			e.printStackTrace();
		}
		return connexion ;
	}
	
	public void fermerConnexion(Connection connexion)
	{
		try
		{
			if ( connexion != null )
			{
				connexion.close();
			}
		} catch (SQLException e)
		{
			// fermeture de la bd échouée
			System.out.println("fermeture de la bd échouée");
			e.printStackTrace();
		}
	}
	
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
}
