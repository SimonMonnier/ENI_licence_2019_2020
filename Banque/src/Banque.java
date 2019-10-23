import java.util.Scanner;

public class Banque {
	
	public static void main(String args[])
	{
		/*Déclarations des variables*/
		CompteBancaire simon;
		Scanner demandeUser;
		int choix = 0;
		/*Création du scanner*/
		demandeUser = new Scanner(System.in);
		/*Demande d'entrée utilisateur*/
		System.out.println("Création d'un nouveau compte bancaire !");
		System.out.println("Veuillez entrer un numéro de compte :");
		String numeroCompte = demandeUser.next();
		System.out.println("Veuillez entrer sa date de céation :");
		String dateCreation = demandeUser.next();
		System.out.println("Veuillez entrer son solde (falcutatif):");
		int solde = demandeUser.nextInt();
		/*Création du compte bancaire*/
		if ( solde != 0)
			simon = new CompteBancaire( numeroCompte, dateCreation, solde);
		else
			simon = new CompteBancaire( numeroCompte, dateCreation);
		/*Affichage choix utilisateur pour tache à effectuer sur le compte*/
		while ( choix != 4 )
		{
			System.out.println("Menu choix :");
			System.out.println("1- Créditer le compte de 500 Euros");
			System.out.println("2- Débiter le compte de 50 Euros");
			System.out.println("3- Etat du compte");
			System.out.println("4- Exit");
			choix = demandeUser.nextInt();
			
			switch (choix)
			{
				case 1 : crediter(simon, 500);
						break;
				case 2 : if ( debiter(simon, 50 ) == 1 )
							System.out.println("Payement refusé !");
						break;
				case 3 : System.out.println( etatCompte(simon) );
						break;
				case 4 : break;
				default : System.out.println("Erreur de choix !");
			}
		}
		demandeUser.close();
	}
	
	/*Fonction crediter*/
	public static void crediter ( CompteBancaire client, int credit )
	{
		client.crediterCompte( credit );
	}
	
	/*Fonction debiter*/
	public static int debiter ( CompteBancaire client, int debit )
	{
		int solvable = client.debiterCompte( debit );
		
		return solvable;
	}
	
	/*Fonction afficher état du compte*/
	public static String etatCompte ( CompteBancaire client)
	{		
		return client.toString();
	}
}
