package fr.mallyance.crm.batch;

import fr.mallyance.crm.domain.entities.Facture;
import fr.mallyance.crm.infrastructure.repository.FactureRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class RelanceFactureReader implements ItemReader<Facture> {

    @Autowired
    private FactureRepository factureRepository;

    private List<Facture> factures;
    private int nextFactureIndex;

    @Override
    public Facture read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        if (factures == null) {
            loadFactures();
        }
        if (nextFactureIndex < factures.size()) {
            return factures.get(nextFactureIndex++);
        }
        return null; // Fin de la lecture
    }

    private void loadFactures() {
        LocalDate targetDate = LocalDate.now().plusDays(5);
        factures = factureRepository.findByDateEcheance(targetDate);
        factures.forEach(facture -> System.err.println("Reférence : " +facture.getReference()));
        nextFactureIndex = 0;
    }
}
