package fr.mallyance.crm.exposition.facture.rest;

import fr.mallyance.crm.application.facture.FactureService;
import fr.mallyance.crm.domain.entities.Facture;
import fr.mallyance.crm.domain.facture.FactureServicePort;
import fr.mallyance.crm.exposition.facture.dto.FactureDto;
import fr.mallyance.crm.exposition.facture.mapper.FactureMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/factures")
@CrossOrigin("*") // Permet de gérer les requêtes depuis Angular
@Tag(name = "Facture", description = "API for managing facture")
public class FactureController {

    Logger logger = Logger.getLogger(FactureController.class.getName());

     @Autowired
     private FactureMapper factureMapper;

     @Autowired
     private FactureServicePort factureService;

    @PostMapping
    @Operation(operationId = "addFacture", method = "POST", summary = "Ajouter une nouvelle facture", description = "récupère les données de l'objet facture passé par la partie front et appelle le service d'ajout d'une nouvelle facture en BDD")
    public ResponseEntity<FactureDto> addFacture(@RequestBody FactureDto factureDto) {

        logger.info("Adding facture: " + factureDto.getReference());
        Facture facture = factureMapper.mappToFacture(factureDto);

        factureService.ajouterFacture(facture);

        System.out.println("Référence : " + facture.getReference());
        System.out.println("Date : " + facture.getDateEtablissement());
        System.out.println("Montant : " + facture.getMontantHT());
        System.out.println("Fournisseur : " + facture.getNomFournisseur());
        System.out.println("Client : " + facture.getNomClient());
        System.out.println("Statut : " + facture.getStatut());

        //return ResponseEntity.ok("Facture ajoutée !");

         return ResponseEntity.ok(factureMapper.mappToFactureDto(facture));
    }

    // REF001	2023-12-31	150	Fournisseur 1	Client 1	payé

    @GetMapping
    @Operation(operationId = "getFactures", method = "GET", summary = "Récupérer toutes les factures", description = "Récupérer toutes les factures disponibles pour les afficher côté font")
    public ResponseEntity<List<FactureDto>> getFactures() {

        logger.info("Get factures");
        List<FactureDto> facturesDto = new ArrayList<>();
        List<Facture> factures = factureService.getFactures();
        logger.info("nombre de factures : " + factures.size());
        factures.forEach(facture -> {
            facturesDto.add(factureMapper.mappToFactureDto(facture));
        });

        //for (int i=1; i<=10; i++) {
        //    FactureDto factureDto = new FactureDto();
        //    factureDto.setReference("REF000"+i);
        //    factureDto.setDateEtablissement(new Date());
        //    factureDto.setDateEcheance(new Date());
        //    factureDto.setTjm(new BigDecimal(650));
        //    factureDto.setNbJours(new BigDecimal(50));
        //    factureDto.setMontantHT(new BigDecimal(1000));
        //    factureDto.setMontantTTC(new BigDecimal(1200));
        //    factureDto.setNomClient("client"+i);
        //    factureDto.setNomFournisseur("fournisseur"+i);
        //    factureDto.setStatut("non payé");
        //    factures.add(factureDto);
        //}

        return ResponseEntity.ok(facturesDto);
    }

    @PutMapping("/{reference}")
    @Operation(operationId = "updateFacture", method = "PUT", summary = "Mettre à jour une facture", description = "Mettre à jour une facture par sa référence passée en paramètre du service")
    public ResponseEntity<FactureDto> updateFacture(
            @PathVariable String reference,
            @Valid @RequestBody FactureDto factureDto) {
        Facture updatedFacture = factureService.modifierFacture(factureMapper.mappToFacture(factureDto));
        return ResponseEntity.ok(factureMapper.mappToFactureDto(updatedFacture));
    }
}
