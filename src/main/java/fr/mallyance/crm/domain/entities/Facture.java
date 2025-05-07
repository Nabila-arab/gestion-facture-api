package fr.mallyance.crm.domain.entities;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

//@Data
//@Builder
public class Facture implements Serializable {

    private int idFacture;
    private String reference;
    private Date dateEtablissement;
    private Date dateEcheance;
    private BigDecimal tjm;
    private BigDecimal nbJours;
    private BigDecimal montantHT;
    private BigDecimal montantTTC;
    private String nomFournisseur;
    private String nomClient;
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
