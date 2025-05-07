package fr.mallyance.crm.infrastructure.jpa;

import fr.mallyance.crm.infrastructure.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepositoryJpa extends JpaRepository<ClientEntity, Integer> {

    @Query("SELECT c FROM ClientEntity c WHERE c.raisonSociale = :raisonSociale")
    List<ClientEntity> findByRaisonSociale(@Param("raisonSociale") String raisonSociale);
}
