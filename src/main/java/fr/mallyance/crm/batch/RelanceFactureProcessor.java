package fr.mallyance.crm.batch;

import fr.mallyance.crm.domain.entities.Facture;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class RelanceFactureProcessor implements ItemProcessor<Facture, Facture> {

    @Override
    public Facture process(Facture facture) {
        // Vous pouvez effectuer des traitements spécifiques ici
        System.out.println("Traitement de la facture : " + facture.getReference());
        return facture;
    }
}