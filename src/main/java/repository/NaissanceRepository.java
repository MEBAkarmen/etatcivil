package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Naissance;

public interface NaissanceRepository extends JpaRepository<Naissance,Long> {

}
