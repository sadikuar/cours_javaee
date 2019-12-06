package com.example.model;

public class Etudiant {
	public String nom;
	private String prenom;
	public Integer age;
	private char sexe;

	public Etudiant(String nom, Integer age, char sexe) {
		super();
		this.nom = nom;
		this.age = age;
		this.sexe = sexe;
	}

	public Etudiant() {
		// TODO Auto-generated constructor stub
	}

	public char getSexe() {
		return this.sexe;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}

	public Integer getAge() {
		return age;
	}
}
