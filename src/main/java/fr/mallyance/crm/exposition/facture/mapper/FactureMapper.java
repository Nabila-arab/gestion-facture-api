package fr.mallyance.crm.exposition.facture.mapper;

import fr.mallyance.crm.domain.entities.Facture;
import fr.mallyance.crm.exposition.facture.dto.FactureDto;
import org.springframework.stereotype.Component;

@Component
public class FactureMapper {

    public Facture mappToFacture(FactureDto factureDto){
         Facture facture = new Facture();

        facture.setIdFacture(factureDto.getIdFacture());
        facture.setReference(factureDto.getReference());
        facture.setDateEtablissement(factureDto.getDateEtablissement());
        facture.setDateEcheance(factureDto.getDateEcheance());
        facture.setTjm(factureDto.getTjm());
        facture.setNbJours(factureDto.getNbJours());
        facture.setMontantHT(factureDto.getMontantHT());
        facture.setMontantTTC(factureDto.getMontantTTC());
        facture.setNomClient(factureDto.getNomClient());
        facture.setNomFournisseur(factureDto.getNomFournisseur());
        facture.setStatut(factureDto.getStatut());

        return facture;
    }

    public FactureDto mappToFactureDto(Facture facture){
        FactureDto factureDto = new FactureDto();

        factureDto.setIdFacture(facture.getIdFacture());
        factureDto.setReference(facture.getReference());
        factureDto.setDateEtablissement(facture.getDateEtablissement());
        factureDto.setDateEcheance(facture.getDateEcheance());
        factureDto.setTjm(facture.getTjm());
        factureDto.setNbJours(facture.getNbJours());
        factureDto.setMontantHT(facture.getMontantHT());
        factureDto.setMontantTTC(facture.getMontantTTC());
        factureDto.setNomClient(facture.getNomClient());
        factureDto.setNomFournisseur(facture.getNomFournisseur());
        factureDto.setStatut(facture.getStatut());

        return factureDto;
    }
}
