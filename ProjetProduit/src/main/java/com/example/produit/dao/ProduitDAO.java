package com.example.produit.dao;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.produit.model.Produit;

public class ProduitDAO {

	private static Map<Integer, Produit> produits = new HashMap<Integer, Produit>();

	static {
		produits.put(1, new Produit(30.0, "Chaise en bois"));
		produits.put(2, new Produit(100.0, "Armoire"));
		produits.put(3, new Produit(49.5, "Peinture bleu"));
		produits.put(4, new Produit(9.99, "Tournevis"));
	}

	public List<Produit> getAllProduits() {
		return produits.values().stream().collect(Collectors.toList());
	}
	
	public void save(Produit produit) {
		produits.put(nextKey(), produit);
	}
	
	private static Integer nextKey() {
		final Comparator<Integer> comp = (k1, k2) -> Integer.compare(k1, k2);

		return produits.keySet().stream().max(comp).get() + 1; 
	}

}
