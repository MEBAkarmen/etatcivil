package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Clinique;

public interface CliniqueRepository extends JpaRepository <Clinique,Long> {

}
