package com.project.etatcivil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.etatcivil.entity.Declaration;

public interface DeclarationRepository extends JpaRepository <Declaration,Long> {

}
