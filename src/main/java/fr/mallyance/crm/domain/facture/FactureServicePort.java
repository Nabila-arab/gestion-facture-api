package fr.mallyance.crm.domain.facture;


import fr.mallyance.crm.domain.entities.Facture;

import java.util.List;

public interface FactureServicePort {
    public Facture getFacture(int id);
    public Facture getFacture(String reference);
    public List<Facture> getFactures();
    public Facture ajouterFacture(Facture facture );
    public Facture modifierFacture(Facture facture);
}
