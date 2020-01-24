package com.example.classeetudian.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Etudiant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long etudiantId;

	@Column
	private String nom;

	@Column
	private String prenom;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "classeId")
	private Classe classe;

	public Etudiant(long etudiantId, String nom, String prenom, Classe classe) {
		this.etudiantId = etudiantId;
		this.nom = nom;
		this.prenom = prenom;
		this.classe = classe;
	}

	public Etudiant() {

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Etudiant [etudiantId=");
		builder.append(etudiantId);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", classe=");
		builder.append(classe);
		builder.append("]");
		return builder.toString();
	}

	public long getEtudiantId() {
		return etudiantId;
	}

	public void setEtudiantId(long etudiantId) {
		this.etudiantId = etudiantId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
