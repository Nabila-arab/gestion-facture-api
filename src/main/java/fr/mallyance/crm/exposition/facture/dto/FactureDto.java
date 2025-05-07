package fr.mallyance.crm.exposition.facture.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL) // Ignore les champs null dans le JSON
public class FactureDto implements Serializable {

    @JsonProperty("idFacture") // Nom de la propriété dans le JSON
    @NotNull
    private int idFacture;

    @JsonProperty("reference") // Nom de la propriété dans le JSON
    @NotNull
    private String reference;

    @JsonProperty("dateEtablissement")
    private Date dateEtablissement;

    @JsonProperty("dateEcheance")
    private Date dateEcheance;

    @JsonProperty("tjm")
    private BigDecimal tjm;

    @JsonProperty("nbJours")
    private BigDecimal nbJours;

    @JsonProperty("montantHT")
    private BigDecimal montantHT;

    @JsonProperty("montantTTC")
    private BigDecimal montantTTC;

    @JsonProperty("nomFournisseur")
    private String nomFournisseur;

    @JsonProperty("nomClient")
    private String nomClient;

    @JsonProperty("statut")
    private String statut;

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateEtablissement() {
        return dateEtablissement;
    }

    public void setDateEtablissement(Date dateEtablissement) {
        this.dateEtablissement = dateEtablissement;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public BigDecimal getTjm() {
        return tjm;
    }

    public void setTjm(BigDecimal tjm) {
        this.tjm = tjm;
    }

    public BigDecimal getNbJours() {
        return nbJours;
    }

    public void setNbJours(BigDecimal nbJours) {
        this.nbJours = nbJours;
    }

    public BigDecimal getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(BigDecimal montantHT) {
        this.montantHT = montantHT;
    }

    public BigDecimal getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(BigDecimal montantTTC) {
        this.montantTTC = montantTTC;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
