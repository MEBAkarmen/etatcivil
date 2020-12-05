package com.project.etatcivil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.etatcivil.entity.Personne;

public interface PersonneRepository extends JpaRepository <Personne , Long> {

}
