package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Declaration;

public interface DeclarationRepository extends JpaRepository <Declaration,Long> {

}
