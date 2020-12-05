package com.project.etatcivil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.etatcivil.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository <Utilisateur,Long> {}
