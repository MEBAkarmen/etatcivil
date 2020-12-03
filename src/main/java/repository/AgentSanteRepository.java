package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.AgentSante;

public interface AgentSanteRepository extends JpaRepository <AgentSante,Long> {

}
