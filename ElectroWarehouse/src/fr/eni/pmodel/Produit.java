package fr.eni.pmodel;


public class Produit {

	/*** Attributs private ***/
	private String nom ;
	public Categorie categorie ;
	private String marque ;
	private int annee ;
	private double prix ;
	private int quantite;
	private String urlImage;
	private String descriptif;
	private String slug;
	
	/*** Accesseurs ***/
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getDescriptif() {
		return descriptif;
	}
	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String nom, Categorie categorie, String marque, int annee, int quantite) {
		String str = nom + categorie + marque + annee + quantite;
		this.slug = str.replaceAll("\\s+","");
	}
	
	/*** Constructeur ***/
	public Produit(String nom, Categorie categorie, String marque, int annee, double prix, int quantite, String urlImage, String descriptif) {
		super();
		this.nom = nom;
		this.categorie = categorie;
		this.marque = marque;
		this.annee = annee;
		this.prix = prix;
		this.quantite = quantite;
		this.urlImage = urlImage;
		this.descriptif = descriptif;
	}
	
	public Produit() {}
	@Override
	public String toString() {
		return "Produit [getNom()=" + getNom() + ", getCategorie()=" + getCategorie() + ", getMarque()=" + getMarque()
				+ ", getAnnee()=" + getAnnee() + ", getPrix()=" + getPrix() + "]";
	}
}
