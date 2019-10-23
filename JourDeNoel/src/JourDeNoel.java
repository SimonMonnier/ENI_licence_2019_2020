import java.util.Scanner;

public class JourDeNoel {
	
	public static void main(String args[])
	{
		/*D�claration des variables*/
		int annee, jourDeNoel;
		String joursDeLaSemaine[] = {"lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"};
		/*Saisie + controle de l'entr�e de l'utilisateur*/
		annee = entreeAnnee();
		/*Calcule du jour au tombe noel selon l'ann�e entr�e*/
		jourDeNoel = calculJourDeNoel(annee);
		/*Affichage du r�sultat*/
		System.out.println("Le jour de No�l en " +  annee + " est un " + joursDeLaSemaine[jourDeNoel]+ " !");
	}
	
	/*Fonction de controle de l'entr�e de l'utilisateur*/
	public static int entreeAnnee()
	{
		Scanner entree;
		entree = new Scanner(System.in);
		int annee = 0;
		while (annee < 1901 || annee > 2099)
		{
			System.out.println("Entrez une ann�e entre 1901 et 2099, pour conna�tre le jour de la semaine o� tombe no�l :");
			annee = entree.nextInt();
			if (annee < 1901 || annee > 2099)
				System.out.println("Choix de l'ann�e incorrecte !");
		}
		entree.close();
		return annee;
	}
	
	/*Fonction de calcul du jour de noel*/
	public static int calculJourDeNoel(int annee)
	{
		/*En 1900 noel est un mardi (1)*/
		int anneeReference = 1900, jourDeNoel = 0;
		boolean bixetil;
		/*Boucle depuis l'ann�e de r�f�rence jusqu'� l'ann�e demand�e*/
		while (anneeReference < annee + 1)
		{
			/*V�rification si l'ann�e est bixetil*/
			if ((anneeReference % 4 == 0 && anneeReference % 100 != 0) || (anneeReference % 400 == 0))
			{
				bixetil = true;
			}	
			else
				bixetil = false;
			/*Calcule du jour de la semaine correspondant � no�l*/
			if (bixetil == true)
			{
				if(jourDeNoel == 5)
				{
					jourDeNoel = 0;
				}
				else if(jourDeNoel == 6)
				{
					jourDeNoel = 1;
				}
				else
				{
					jourDeNoel += 2;
				}
			}
			else
				{
					if(jourDeNoel == 6)
						jourDeNoel = 0;
					else
						jourDeNoel += 1;
				}
			anneeReference++;
		}
		return jourDeNoel;
	}
}
