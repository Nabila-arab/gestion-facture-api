package fr.mallyance.crm.application.facture;

import fr.mallyance.crm.domain.entities.Facture;
import fr.mallyance.crm.domain.facture.FactureServicePort;
import fr.mallyance.crm.infrastructure.repository.FactureRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FactureService implements FactureServicePort {

    private final FactureRepository factureRepository;

    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    @Override
    public Facture getFacture(int id) {
        return null;
    }

    @Override
    public Facture getFacture(String reference) {
        return null;
    }

    @Override
    public List<Facture> getFactures() {
        return factureRepository.findAllFactures();
    }

    @Override
    public Facture ajouterFacture(Facture facture) {
        //Facture response = factureRepository.addFacture(facture);
        return factureRepository.addFacture(facture);
    }

    @Override
    public Facture modifierFacture(Facture facture) {
        if(factureRepository.findFacture(facture.getIdFacture()) != null){
            return factureRepository.updateFacture(facture);
        }
        return null;
    }

    //if(factureRepository.findFactureByReference(facture.getReference()) != null){
    //    return factureRepository.updateFacture(facture);
    //}
    //    return null;
}
