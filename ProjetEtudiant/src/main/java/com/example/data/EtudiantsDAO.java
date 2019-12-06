package com.example.data;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.model.Etudiant;

public class EtudiantsDAO {

	private static Map<Integer, Etudiant> etudiants = new HashMap<>();

	static {

		etudiants.put(1, new Etudiant("Jacques S.", 22, 'M'));
		etudiants.put(2, new Etudiant("Veronique D.", 19, 'F'));

	}

	public List<Etudiant> getAllEtudianst() {
		return etudiants.values().stream().collect(Collectors.toList());
	}

	public void save(Etudiant etudiant) {
		etudiants.put(nextKey(), etudiant);
	}

	private static Integer nextKey() {
		final Comparator<Integer> comp = (k1, k2) -> Integer.compare(k1, k2);

		return etudiants.keySet().stream().max(comp).get() + 1;
	}
}
