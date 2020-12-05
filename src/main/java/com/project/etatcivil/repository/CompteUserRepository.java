package com.project.etatcivil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.etatcivil.entity.CompteUser;

public interface CompteUserRepository extends JpaRepository <CompteUser,Long> {

}
