package com.example.produit.model;

public class Produit {
	
	public Produit(double prix, String nom) {
		this.prix = prix;
		this.nom = nom;
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

	private double prix;
	private String nom;

}
