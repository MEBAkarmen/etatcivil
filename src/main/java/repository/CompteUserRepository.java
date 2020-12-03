package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.CompteUser;

public interface CompteUserRepository extends JpaRepository <CompteUser,Long> {

}
