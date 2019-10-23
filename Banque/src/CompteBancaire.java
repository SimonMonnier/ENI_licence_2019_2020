
public class CompteBancaire {

	/*** Attributs private ***/
	private String numeroCompte_;
	private double solde_;
	private String dateCreation_;
	private int CODE_ERREUR = 0;
	
	/*** Constructeurs ***/
	public CompteBancaire ( String numeroCompte, String dateCreation ) 
	{
		this.numeroCompte_ = numeroCompte;
		this.dateCreation_ = dateCreation;
	}
	public CompteBancaire ( String numeroCompte, String dateCreation, double solde ) 
	{
		this.numeroCompte_ = numeroCompte;
		this.dateCreation_ = dateCreation;
		this.solde_ = solde;
	}
	public CompteBancaire () 
	{
		/*Appel d'un autre constructeur*/
		this ( "indéfini", "25/08/1986", 0);
	}
	
	/*** Accessseurs ***/
	public String getNumeroCompte() { return numeroCompte_; }
	public double getSolde() { return solde_; }
	public String getDateCreation() { return dateCreation_;}
	public  void setSolde( double solde ) { solde_ = solde; }
	
	/*** Méthodes ***/
	public void crediterCompte( double credit )
	{
		solde_ += credit;
	}
	
	public int debiterCompte( double debit )
	{
		if ( solde_ >= debit )
		{
			solde_ -= debit;
			return CODE_ERREUR;
		}
		else
			return CODE_ERREUR = 1;
	}
	
	public String toString()
	{
		return ("Etat du compte numéro " + numeroCompte_ + " créé le " + dateCreation_ + " : \n" + "Solde : " + solde_ + " $");
	}
}
