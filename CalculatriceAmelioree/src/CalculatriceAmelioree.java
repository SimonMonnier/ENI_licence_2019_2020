import java.util.Scanner;

public class CalculatriceAmelioree {
	static int CODE_ERREUR = 0;
	/*Fonction puissance*/
	static double calculPuissance(int nombre1, int nombre2)
	{
		double result = nombre1;
		int tmp = nombre2;
		while(tmp > 1)
		{
			result *= nombre1;
			tmp--;
		}
		if (nombre2 == 0)
		{
			result = 1;
		}
		return result;
	}
	/*Fonction addition*/
	static double calculAddition(int nombre1, int nombre2)
	{
		double result = nombre1 + nombre2;
		
		return result;
	}
	/*Fonction soustraction*/
	static double calculSoustraction(int nombre1, int nombre2)
	{
		double result = nombre1 - nombre2;
		
		return result;
	}
	/*Fonction division*/
	static double calculDivision(int nombre1, int nombre2)
	{
		double result = nombre1 / nombre2;
		
		return result;
	}
	/*Fonction multiplication*/
	static double calculMultipplication(int nombre1, int nombre2)
	{
			double result = nombre1 * nombre2;
			return result;
	}

	/*Programme principal*/
	public static void main (String args[])
	{
		/*D�claration des variables*/
		double result = 0;
		int nombre1, nombre2;
		int exit = 0;
		char operateur;
		boolean ok = true;
		Scanner operation;
		
		/*Cr�ation des objets*/
		operation = new Scanner(System.in);
		
		while (exit != 1)
		{
			System.out.println("Nouvelle op�ration");
			
			/*Saisie des donn�es*/
			System.out.println("Entrez un entier :");
			nombre1 = operation.nextInt();
			System.out.println("Entrez un op�rateur :");
			operateur = operation.next().charAt(0);
			System.out.println("Entrez un entier :");
			nombre2 = operation.nextInt();

			/*Application de l'op�ration selon l'op�rateur*/
			switch (operateur)
			{
				case '+' : result = calculAddition(nombre1, nombre2);
							break;
				case '-' : result = calculSoustraction(nombre1, nombre2);
							break;
				case '/' : result = calculDivision(nombre1, nombre2);
							if (result == 0)
							{
								ok = false;
							}
							break;
				case '*' : result = calculMultipplication(nombre1, nombre2);
							break;
				case 'p' : result = calculPuissance(nombre1, nombre2);
							break;
				default : ok = false;
			}
			
			/*Affichage du r�sultat*/
			if (ok)
			{
				System.out.println( nombre1 + " " + operateur + " " + nombre2 + " " +  "=" +  " " + result + "\n");
			}
			else
			{
				System.out.println("Op�ration impossible \n");
				ok = true;
			}
			
			/*Affichage du choix : Quitter ou recommencer*/
			System.out.println("Voulez-vous continuer ? \n");
			System.out.println("Nouvelle op�ration tapez 0");
			System.out.println("exit tapez 1 ");
			exit = operation.nextInt();
		}
		
		/*Close l'objet scanner*/
		operation.close();
		System.out.println("Fin !");
	}
}
