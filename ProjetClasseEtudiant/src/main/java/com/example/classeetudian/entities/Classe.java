package com.example.classeetudian.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long classeId;
	
	@Column
	private String classeNom;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classe")
	private List<Etudiant> listEtudiants;

	public Classe(long classeId, String classeNom) {
		super();
		this.classeId = classeId;
		this.classeNom = classeNom;
	}
	
	public Classe() {

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Classe [classeId=");
		builder.append(classeId);
		builder.append(", classeNom=");
		builder.append(classeNom);
		builder.append("]");
		return builder.toString();
	}

	public long getClasseId() {
		return classeId;
	}

	public void setClasseId(long classeId) {
		this.classeId = classeId;
	}

	public String getClasseNom() {
		return classeNom;
	}

	public void setClasseNom(String classeNom) {
		this.classeNom = classeNom;
	}
	
	

}
