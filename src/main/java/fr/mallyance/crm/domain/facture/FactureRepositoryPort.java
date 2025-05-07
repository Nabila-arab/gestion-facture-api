package fr.mallyance.crm.domain.facture;

import fr.mallyance.crm.domain.entities.Facture;

import java.time.LocalDate;
import java.util.List;

public interface FactureRepositoryPort {

    public Facture findFacture(int id);
    public Facture findFactureByReference(String reference);
    public Facture addFacture(Facture facture);
    public List<Facture> findAllFactures();
    public List<Facture> findByDateEcheance(LocalDate date);
    public Facture updateFacture(Facture facture);

}
