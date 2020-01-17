package com.example.classeetudian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.classeetudian.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}
