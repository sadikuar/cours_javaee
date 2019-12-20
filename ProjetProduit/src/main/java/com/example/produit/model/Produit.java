package com.example.produit.model;

public class Produit {
	
	public Produit(double prix, String nom) {
		this.prix = prix;
		this.nom = nom;
	}
	
	public Produit() {
		
	}
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Produit [prix=");
		builder.append(prix);
		builder.append(", nom=");
		builder.append(nom);
		builder.append("]");
		return builder.toString();
	}


	private double prix;
	private String nom;

}
