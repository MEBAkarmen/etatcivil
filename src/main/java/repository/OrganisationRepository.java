package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Organisation;

public interface OrganisationRepository extends JpaRepository <Organisation,Long> {
}