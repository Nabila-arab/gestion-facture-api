package fr.mallyance.crm.infrastructure.jpa;

import fr.mallyance.crm.infrastructure.entities.FactureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FactureRepositoryJpa extends JpaRepository<FactureEntity, Integer> {

    Optional<List<FactureEntity>> findAllByNomClient(String nomClient);

    @Query("SELECT f FROM FactureEntity f WHERE f.dateEcheance <= :targetDate")
    List<FactureEntity> findByDateEcheance(@Param("targetDate") LocalDate targetDate);

}
