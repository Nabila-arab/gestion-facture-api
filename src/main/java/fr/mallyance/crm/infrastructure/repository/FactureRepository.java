package fr.mallyance.crm.infrastructure.repository;

import fr.mallyance.crm.domain.entities.Facture;
import fr.mallyance.crm.domain.facture.FactureRepositoryPort;
import fr.mallyance.crm.infrastructure.entities.FactureEntity;
import fr.mallyance.crm.infrastructure.jpa.FactureRepositoryJpa;
import fr.mallyance.crm.infrastructure.mappers.FactureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FactureRepository implements FactureRepositoryPort {

    private final FactureRepositoryJpa factureRepositoryJpa;

    private final FactureMapper factureMapper;

    public FactureRepository(FactureRepositoryJpa factureRepositoryJpa, FactureMapper factureMapper) {
        this.factureRepositoryJpa = factureRepositoryJpa;
        this.factureMapper = factureMapper;
    }

    @Override
    public Facture findFacture(int id) {
        Optional<FactureEntity> factureMybe = factureRepositoryJpa.findById(id);

        return factureMybe.map(factureMapper::mapToFacture).orElse(null);
    }

    @Override
    public Facture findFactureByReference(String reference) {

        //Optional<FactureEntity> factureMybe = factureRepositoryJpa.findById(reference);
//
        //return factureMybe.map(factureMapper::mapToFacture).orElse(null);
        return null;
    }

    @Override
    public Facture addFacture(Facture facture) {
        FactureEntity factureEntity = factureMapper.mapToFactureEntity(facture);
        FactureEntity entity = factureRepositoryJpa.save(factureEntity);
        return factureMapper.mapToFacture(entity);
    }

    @Override
    public List<Facture> findAllFactures() {
        Optional<List<FactureEntity>> factureEntitiesMybe = Optional.of(factureRepositoryJpa.findAll()); //llByNomClient("");
        if(factureEntitiesMybe.isPresent()) {
            List<Facture> factures = new ArrayList<>();
            factureEntitiesMybe.get().forEach(entity -> {
                factures.add(factureMapper.mapToFacture(entity));
            });
            return factures;
        }else{
            // gestion d'exception
            return new ArrayList<>();
        }
    }

    @Override
    public List<Facture> findByDateEcheance(LocalDate date) {
        List<Facture> factures = new ArrayList<>();

        factureRepositoryJpa.findByDateEcheance(date).forEach(entity -> {
            factures.add(factureMapper.mapToFacture(entity));
        });

        return factures;
    }

    @Override
    public Facture updateFacture(Facture facture) {
        return factureMapper.mapToFacture(factureRepositoryJpa.save(factureMapper.mapToFactureEntity(facture)));
    }
}
