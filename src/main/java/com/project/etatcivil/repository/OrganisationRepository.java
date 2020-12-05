package com.project.etatcivil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.etatcivil.entity.Organisation;

public interface OrganisationRepository extends JpaRepository <Organisation,Long> {
}